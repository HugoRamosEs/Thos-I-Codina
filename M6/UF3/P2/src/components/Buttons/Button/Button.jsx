import { memo } from "react";
import styles from "./Button.module.scss";

const Button = memo(function Button({ text }) {
    const id = text.toLowerCase().replace(/\s+/g, '_');

    return (
        <button b_id={`b_${id}`} className={styles[id]}>{text}</button>
    );
});

export default Button;