import styles from "./Nota.module.scss";
import { memo } from "react";

const Nota = memo(function Nota({ nota }) {
    return (
      <>
        <div id={nota._id} className={styles.nota}>
          <form>
              <label htmlFor={`nTitle_${nota._id}`} className={styles.nLabelTitle}>Title:</label>
              <input type="text" id={`nTitle_${nota._id}`} className={styles.nTitle} name="nTitle" defaultValue={nota.title} />
              <label htmlFor={`nState_${nota._id}`} className={styles.nLabelState}>State:</label>
              <select id={`nState_${nota._id}`} className={styles.nState} name="nState" defaultValue={nota.status}>
                  <option value="Published">Published</option>
                  <option value="Draft">Draft</option>
              </select>
              <label htmlFor={`nBody_${nota._id}`} className={styles.nLabelBody}>Body:</label>
              <textarea id={`nBody_${nota._id}`} className={styles.nBody} name="nBody" defaultValue={nota.content}></textarea>
              <button id={`nUpdate_${nota._id}`} className={styles.nUpdate} type="submit">Update</button>
              <button id={`nDelete_${nota._id}`} className={styles.nDelete} type="submit">Delete</button>
          </form>
        </div>
      </>
    );
});
  

export default Nota;
