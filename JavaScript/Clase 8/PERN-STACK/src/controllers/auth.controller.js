import { pool } from "../db.js";
import bcrypt from "bcrypt";
import {createAccessToken} from "../libs/jwt.js"
import md5 from "md5";
export const signin = async (req, res) => {
    const { email, password } = req.body;

    try {
        const result = await pool.query("SELECT * FROM usuarios WHERE email=$1", [email]);

        if (result.rowCount === 0) {
            return res.status(400).json({ message: "El correo no está registrado" });
        }

        const validPassword = await bcrypt.compare(password, result.rows[0].password);

        if (!validPassword) {
            return res.status(400).json({ message: "La contraseña es incorrecta" });
        }

        const token = await createAccessToken({ id: result.rows[0].id });
        console.log(result.rows[0]);

        res.cookie("token", token, {
            httpOnly: true,
            sameSite: "none",
            maxAge: 60 * 60 * 24 * 1000,
            secure: true, // Asegúrate de que secure esté configurado correctamente si estás en un entorno de producción con HTTPS
        });

        return res.json(result.rows[0]);
    } catch (error) {
        console.error("Error al iniciar sesión:", error);
        return res.status(500).json({ message: "Error interno del servidor" });
    }
};

export const signup =  async(req, res,next) => {
    const { name, email, password } = req.body;
    console.log(name,email,password)
    try{
        const hasheadPassword=await bcrypt.hash(password,10);
        md5(email);
        const gravatar="https://gravatar.com/avatar/"+md5(email);
        const result = await pool.query("INSERT INTO usuarios (name, email, password,gravatar) VALUES ($1, $2, $3, $4) Returning *", [name, email, hasheadPassword,gravatar]);
        const token =await createAccessToken({id: result.rows[0].id});
        console.log(result)
        res.cookie("token",token,{
            httpOnly:true,
            sameSite:"none",
            maxAge: 60*60*24*1000,
        })
     return res.json(result.rows[0]);
    }catch(error){
        if(error.code==="23505"){
            return res.status(400).json({message:"El correo ya esta registrado"});
        }
        next(error);
    }
};

export const signout = (req, res) => {
    try {
        // Borrar la cookie del token
        res.clearCookie("token");

        // Responder con un mensaje de sesión cerrada
        return res.json({ message: "Sesión cerrada" });
    } catch (error) {
        console.error("Error al cerrar sesión:", error);
        return res.status(500).json({ message: "Error interno del servidor al cerrar sesión" });
    }
};

export const profile = async (req, res) => {
    try {
        const result = await pool.query("SELECT * FROM usuarios WHERE id =$1", [req.usuarioId]);
        
        if (result.rowCount === 0) {
            return res.status(404).json({ message: "Usuario no encontrado" });
        }

        return res.json(result.rows[0]);
    } catch (error) {
        console.error("Error al obtener el perfil:", error);
        return res.status(500).json({ message: "Error interno del servidor al obtener el perfil" });
    }
};
