import styles from "./Footer.module.scss"
import { Link } from "react-router-dom"

function Footer() {
  return (
    <footer className={styles.footer}>
        <nav className={styles.f_nav}>
            <ul>
                <li><Link to="/">RESOURCES</Link></li>
                <li><Link to="/">ABOUT US</Link></li>
            </ul>
        </nav>
        <span>Hugo Ramos - DAW 2</span>
    </footer>
  )
}

export default Footer