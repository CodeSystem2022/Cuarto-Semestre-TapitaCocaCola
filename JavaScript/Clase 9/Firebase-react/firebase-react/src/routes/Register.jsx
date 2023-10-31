// eslint-disable-next-line no-unused-vars
import React,{useContext,useState} from "react";
import { useNavigate } from "react-router-dom";
import { UserContext } from "../context/UserProvider";


const Register = () => {
    const[email,setEmail]=useState("prueba@mail.com");
    const[password,setPassword]=useState("123456");

    const navegate=useNavigate();
    const{registerUser}=useContext(UserContext);
    const handleSubmit=async(e)=>{
        e.preventDefault();
        console.log("procesando form: ",email,password)
        try{
            await registerUser(email,password);
            console.log("Usuarios creados");
            navegate("/");
        }catch(error){
            console.log(error.code);
        }
    }
  return (
    <>
    <div>
      <h1>Registro</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="email"
          placeholder="Ingrese email"
          value={email}
          onChange={(e)=>setEmail(e.target.value)} // Corregido el manejador de cambio
        />
        <input
          type="password"
          placeholder="Ingrese Password"
          value={password}
          onChange={(e)=>setPassword(e.target.value)} // Corregido el manejador de cambio
        />
        <button type="submit">Register</button>
      </form>
    </div>
    </>
  );
}

export default Register;
