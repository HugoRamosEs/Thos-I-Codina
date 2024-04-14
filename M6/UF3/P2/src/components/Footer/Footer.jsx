import styles from "./Footer.module.scss";

function Footer() {
  return (
    <footer id="footer">
        <nav className={styles.navbar_footer}>
            <ul>
                <li><a href="">HOSTING CONFIABLE</a></li>
                <li><a href="">CREAR WEB</a></li>
                <li><a href="">RECURSOS</a></li>
                <li><a href="">APRENDRE</a></li>
                <li><a href="">NOSALTRES</a></li>
            </ul>
        </nav>
    </footer>
  )
}

export default Footer