import styles from './ModalCreate.module.scss';
import { Modal } from 'react-bootstrap';
import { useState, useEffect, forwardRef } from 'react';

const ModalCreate = forwardRef(function ModalCreate({ showCreateModal, setShowCreateModal, handleCreate }, ref) {
    const [select, setSelect] = useState("Draft");
    const [frmErrors, setFrmErrors] = useState({});

    const handleStateChange = (e) => {
        setSelect(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        const errors = {};
        const frmData = {};

        const inputs = document.querySelectorAll('input[type="text"], textarea');
        inputs.forEach(input => {
            const name = input.name;
            const value = input.value.trim();
            if (!value) {
                errors[name] = `${name.charAt(0).toUpperCase() + name.substring(1)} is required`;
            } else {
                if (name !== "nTitle" && name !== "nBody"){
                    frmData[name] = value;
                }
            }
        });

        setFrmErrors(errors);

        if (Object.keys(errors).length === 0) {
            handleCreate(frmData); 
        }
    };

    useEffect(() => {
        setFrmErrors({});
    }, [showCreateModal]);

    return (
        <Modal show={showCreateModal} onHide={() => setShowCreateModal(false)} centered>
            <Modal.Header closeButton>
                <Modal.Title>Create Note</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <div>
                    <form >
                        <input type="text" className="form-control rounded-0 mb-2" id="title" name="title" placeholder="Title (Required)" required />
                        {frmErrors.title && (<span className={styles.error_message}>{frmErrors.title}</span>)}
                        <textarea className="form-control rounded-0 mb-2 mt-2 " id="content" name="content" placeholder="Content (Required)" required />
                        {frmErrors.content && (<span className={styles.error_message}>{frmErrors.content}</span>)}
                        <select className="form-select rounded-0 mt-2" id="status" name="status" defaultValue={select} onChange={handleStateChange} ref={ref}>
                            <option defaultValue="Published">Published</option>
                            <option defaultValue="Draft">Draft</option>
                        </select>
                    </form>
                </div>
            </Modal.Body>
            <Modal.Footer className="d-flex justify-content-center">
                <button className="btn btn-secondary rounded-0" onClick={() => setShowCreateModal(false)}>Cancel</button>
                <button className="btn btn-success rounded-0" type="submit" onClick={handleSubmit}>Create</button>
            </Modal.Footer>
        </Modal>
    );
});

export default ModalCreate;
