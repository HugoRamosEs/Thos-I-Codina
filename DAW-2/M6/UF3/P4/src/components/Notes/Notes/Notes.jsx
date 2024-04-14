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
  const [ noteToDelete, setNoteToDelete ] = useState(null);
  const { login } = useContext(LoginContext);
  const [ message, setMessage ] = useState("");
  const [ showMessageModal, setShowMessageModal ] = useState(false);
  const nCreate = useRef(null);
  const select = useRef(null);

  const handleNCreateClick = () => {
    setShowCreateModal(true);
  };

  const handleButtons = async (e) => {
    e.preventDefault();
    if (e.target === nCreate.current) {
      handleNCreateClick();
    } else {
      const nButton_id = e.target.getAttribute("id");
      const parts = nButton_id.split("_");
      const action = parts[0];
      const id = parts[1];
      
      if (nButton_id) {
        if (action === "nUpdate") {
          setShowUpdateModal(true);
          setNoteToUpdate(id);
        } else if (action === "nDelete") {
          setShowDeleteModal(true);
          setNoteToDelete(id);
        }
      }
    }
  };

  const handleCreate = async (dades) => {
    dades.status = select.current.value;
    dades.author = login.id;
    console.log(dades);

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
          {notes && notes.length > 0 ? (
            <>
              {notes.map((nota) => (
                <Nota key={nota._id} nota={nota} />
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
