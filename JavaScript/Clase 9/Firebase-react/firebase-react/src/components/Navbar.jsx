import  { useContext } from "react"; // Importa useContext desde 'react'
import { NavLink } from "react-router-dom";
import { UserContext } from "../context/UserProvider";

const Navbar = () => {
  const { user, setUser } = useContext(UserContext);

  return (
    <div>
      {user ? (
        <>
          <NavLink to="/">Inicio</NavLink> {/* Corregido "inicio" a "Inicio" */}
          <button onClick={() => setUser(false)}>Logout</button>
        </>
      ) : (
            <NavLink to="/login">Login</NavLink>
      )}
    </div>
  );
}

export default Navbar;
