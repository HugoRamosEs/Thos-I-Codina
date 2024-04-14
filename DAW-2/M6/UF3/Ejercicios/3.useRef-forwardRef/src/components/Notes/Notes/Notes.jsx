import 'bootstrap/dist/css/bootstrap.min.css';
import styles from "./Notes.module.scss";
import Nota from "../Nota/Nota";
import LoginContext from "../../../context/LoginContext";
import ModalDelete from "../../Modals/ModalDelete/ModalDelete";
import ModalUpdate from "../../Modals/ModalUpdate/ModalUpdate";
import ModalCreate from "../../Modals/ModalCreate/ModalCreate";
import ModalMessage from "../../Modals/ModalMessage/ModalMessage";
import { useEffect, useState, useContext, useRef } from "react";


function Notes() {
  const [ notes, setNotes ] = useState([]);
  const [ showCreateModal, setShowCreateModal ] = useState(false);
  const [ showUpdateModal, setShowUpdateModal ] = useState(false);
  const [ noteToUpdate, setNoteToUpdate ] = useState(null);
  const [ showDeleteModal, setShowDeleteModal ] = useState(false);
  const { login } = useContext(LoginContext);
  const [ message, setMessage ] = useState("");
  const [ noteToDelete, setNoteToDelete ] = useState(null)
  const [ showMessageModal, setShowMessageModal ] = useState(false);
  const nCreate = useRef(null);
  const select = useRef(null);
  const btnDelete = useRef(null);
  const frm_create = useRef(null);
  const frm_title = useRef('');
  const frm_select = useRef('Draft');
  const frm_content = useRef('');
  const [ noteCreate, setNoteCreate ] = useState(false);

  const handleButtons = async (e) => {
    e.preventDefault();
    if (e.target === nCreate.current) {
      setNoteCreate(!noteCreate);
    } else if (e.target === frm_create.current){
      const dades = {
        title: frm_title.current.value,
        content: frm_content.current.value,
        status: frm_select.current.value,
        author: login.id,
      }

      handleCreate(dades);
    } 
    
    else {
      const nButton_id = e.target.getAttribute("id");
      let action;
      let id;
      if (nButton_id){
        const parts = nButton_id.split("_");
        action = parts[0];
        id = parts[1];

        if (action === "nUpdate") {
          setShowUpdateModal(true);
          setNoteToUpdate(id);
        }
      }
    }
  };

  const handleCreate = async (dades) => {
    try {
      const response = await fetch("http://localhost:8081/notes/create", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(dades),
        credentials: "include",
      });

      if (!response.ok) {
        const errorMessage = await response.json();
        throw new Error(errorMessage.error);
      }

      setShowCreateModal(false);
      fetchData();
      const res = await response.text();
      setMessage(res);
      setShowMessageModal(true);
      setNoteCreate(false)
    } catch (error) {
      console.log("Error: ", error);
    }
  };

  const handleUpdate = async () => {
    const nTitle = document.getElementById(`nTitle_${noteToUpdate}`).value;
    const nState = document.getElementById(`nState_${noteToUpdate}`).value;
    const nBody = document.getElementById(`nBody_${noteToUpdate}`).value;
    const dades = {
      title: nTitle,
      status: nState,
      content: nBody,
    };

    try {
      const response = await fetch(`http://localhost:8081/notes/update/${noteToUpdate}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(dades),
        credentials: "include",
      });

      if (!response.ok) {
        const errorMessage = await response.json();
        throw new Error(errorMessage.error);
      }

      setShowUpdateModal(false);
      fetchData();
      const res = await response.text();
      setMessage(res);
      setShowMessageModal(true);
    } catch (error) {
      console.log("Error: ", error);
    }
  }

  const handleForwardDelete = (id) => {
    setShowDeleteModal(true);
    setNoteToDelete(id)
  }

  const handleDelete = async () => {
    try {
      const response = await fetch(`http://localhost:8081/notes/delete/${noteToDelete}`, {
        method: "DELETE",
        credentials: "include",
      });

      if (!response.ok) {
        const errorMessage = await response.json();
        throw new Error(errorMessage.error);
      }

      setShowDeleteModal(false);
      fetchData();
      const res = await response.text();
      setMessage(res);
      setShowMessageModal(true);
    } catch (error) {
      console.log("Error: ", error);
    }
  };

  const fetchData = async () => {
    try {
      const response = await fetch("http://localhost:8081/notes/read", {
        method: "GET",
        credentials: "include",
      });

      const notes = await response.json();
      console.log(notes);
      setNotes(notes);
    } catch (error) {
      console.log("Error: ", error);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <>
      <div onClick={handleButtons} className={styles.main_notes}>
        <h2>User Notes</h2>
        <button ref={nCreate} className={styles.nCreate}>Create Note</button>
        <div id="main_notes">
          {noteCreate ? (
            <>
              <div className={styles.nota}>
                <form>
                  <label htmlFor='nCreate_title' className={styles.nLabelTitle}>Title:</label>
                  <input type="text" id='nCreate_title' ref={frm_title} className={styles.nTitle} name="nCreate_title"/>
                  <label htmlFor='nCreate_state' className={styles.nLabelState}>State:</label>
                  <select id='nCreate_state' ref={frm_select} className={styles.nState} name="nCreate_state">
                    <option value="Published">Published</option>
                    <option value="Draft">Draft</option>
                  </select>
                  <label htmlFor='nCreate_body' className={styles.nLabelBody}>Body:</label>
                  <textarea id='nCreate_body' ref={frm_content} className={styles.nBody} name="nCreate_body"></textarea>
                  <button id='nCreate_btnCreate' ref={frm_create} className={styles.nUpdate} type="submit">Create</button>
                </form>
              </div>
            </>
          ) : null}
          {notes && notes.length > 0 ? (
            <>
              {notes.map((nota) => (
                <Nota key={nota._id} nota={nota} ref={btnDelete} handleForwardDelete={() => handleForwardDelete(nota._id)} />
              ))}
            </>
          ) : (
            <p className={styles.no_notes}>There are no existing notes.</p>
          )}
        </div>
      </div>

      <ModalCreate showCreateModal={showCreateModal} setShowCreateModal={setShowCreateModal} handleCreate={handleCreate} ref={select} />
      <ModalUpdate showUpdateModal={showUpdateModal} setShowUpdateModal={setShowUpdateModal} handleUpdate={handleUpdate} />
      <ModalDelete showDeleteModal={showDeleteModal} setShowDeleteModal={setShowDeleteModal} handleDelete={handleDelete} />
      <ModalMessage showMessageModal={showMessageModal} setShowMessageModal={setShowMessageModal} message={message} />
    </>
  );
}

export default Notes;
