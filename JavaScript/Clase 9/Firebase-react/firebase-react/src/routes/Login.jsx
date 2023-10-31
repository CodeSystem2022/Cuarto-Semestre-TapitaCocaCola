import { useContext } from "react";
import { UserContext } from "../context/UserProvider";
import{useNaviga} from "react-router-dom";

const Login=()=>{
    const{user,setUser}=useContext(UserContext);
    const navigate=useNaviga();

    const handleClickLogin=()=>{
        setUser(true);
        navigate("/");
    }
    return(
        <>
        <h1>Login</h1>
        <h2>{user ? "En linea":"Offline"}</h2>
        <button onClick={handleClickLogin}>Acceder</button>
        </>
    );
};

export default Login;