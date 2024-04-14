import styles from "./MainMenu.module.scss";
import ButtonCart from "../Buttons/ButtonCart/ButtonCart";

function MainMenu() {

  return (
    <div id="main-menu">
        <nav className={styles.navbar}>
            <ul>
                <li><a href="">HOME</a></li>
                <li><a href="">SOBRE NOSALTRES</a></li>
                <li><a href="">PRODUCTES</a></li>
                <li><a href="">PRÀCTICA 4</a></li>
                <li><a href="">CONTACTE</a></li>
            </ul>
        </nav>
        <ButtonCart/>
    </div>
  )
}

export default MainMenu;