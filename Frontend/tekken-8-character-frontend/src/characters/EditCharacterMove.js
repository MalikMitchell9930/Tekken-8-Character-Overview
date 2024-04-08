import React, {useEffect, useState} from "react";
import { Container } from "react-bootstrap";
import axios from "axios";
import{Link, useNavigate, useParams} from "react-router-dom";


export default function EditCharacterMove() {
  let navigate = useNavigate();

  const {id} = useParams();

  const[characterMove, setCharacterMove] = useState({
    moveName: "", 
    annotation: "", 
    hitLevel: "", 
    startupFrames: "", 
    onHit: "",
    onBlock: "",
    onCounterHit: "",
  });

  const{moveName, annotation, hitLevel, startupFrames, onHit, onBlock, onCounterHit} = characterMove;

  const onInputChange = (e) => {
    setCharacterMove({...characterMove,[e.target.name]: e.target.value});
  };

  useEffect(() =>{
    loadCharacterMove();
  }, []);

  const loadCharacterMove = async () =>{
    const result = await axios.get(`http://localhost:8080/overview/moves/${id}`);
    setCharacterMove(result.data);
  }

  const onSubmit = async(e) =>{
    e.preventDefault();
    await axios.put(`http://localhost:8080/overview/moves/${id}`,characterMove);
    navigate(-1);
  };


  const deleteCharacterMove = async (id) => {
    await axios.delete(`http://localhost:8080/overview/moves/${characterMove.id}`);
    navigate(-1);
  };
  return (
    <div>
        <Container>
        <div className="row">
                <div className="col-md-8 offset-md-2 border rounded p-4 mt-2 shadow bg-light">
                    <h2 className="text-center m-4">
                        Edit Character Move
                        </h2>
                        <form onSubmit={(e) => onSubmit(e)}>
                        <div className="mb-3">
                          <label htmlFor="MoveName" className="form-label">
                            Move Name
                          </label>
                          <input
                          type={"text"}
                          className="form-control"
                          placeholder="Enter the Move Name"
                          name="moveName"
                          value={moveName}
                          onChange={(e) => onInputChange(e)}
                          />
                        </div>

                        <div className="mb-3">
                          <label htmlFor="Annotation" className="form-label">
                            Move Annotation
                          </label>
                          <input
                          type={"text"}
                          className="form-control"
                          placeholder="Enter the Move Annotation"
                          name="annotation"
                          value={annotation}
                          onChange={(e) => onInputChange(e)}
                          />
                        </div>

                        <div className="mb-3">
                          <label htmlFor="HitLevel" className="form-label">
                            Hit Level
                          </label>
                          <input
                          type={"text"}
                          className="form-control"
                          placeholder="Enter the Move Hit Level"
                          name="hitLevel"
                          value={hitLevel}
                          onChange={(e) => onInputChange(e)}
                          />
                        </div>

                        <div className="mb-3">
                          <label htmlFor="StartupFrams" className="form-label">
                            Startup Frams
                          </label>
                          <input
                          type={"text"}
                          className="form-control"
                          placeholder="Enter the Move Startup Frames"
                          name="startupFrames"
                          value={startupFrames}
                          onChange={(e) => onInputChange(e)}
                          />
                        </div>

                        <div className="mb-3">
                          <label htmlFor="OnHit" className="form-label">
                            Frames On Hit
                          </label>
                          <input
                          type={"text"}
                          className="form-control"
                          placeholder="Enter the Move Frames On Hit"
                          name="onHit"
                          value={onHit}
                          onChange={(e) => onInputChange(e)}
                          />
                        </div>

                        <div className="mb-3">
                          <label htmlFor="OnBlock" className="form-label">
                            Frames On Block
                          </label>
                          <input
                          type={"text"}
                          className="form-control"
                          placeholder="Enter the Move Frames On Block"
                          name="onBlock"
                          value={onBlock}
                          onChange={(e) => onInputChange(e)}
                          />
                        </div>

                        <div className="mb-3">
                          <label htmlFor="OnCounterHit" className="form-label">
                            Counter Hit
                          </label>
                          <input
                          type={"text"}
                          className="form-control"
                          placeholder="Enter the Move Properties On Counter Hit"
                          name="onCounterHit"
                          value={onCounterHit}
                          onChange={(e) => onInputChange(e)}
                          />
                        </div>
                        <Link className="btn btn-outline-danger mx-2" 
                        to="/"
                        >
                          Cancel
                        </Link>
                        <button type="submit" className="btn btn-outline-primary">
                          Submit
                        </button>
                        <button 
                         className="btn text-light bg-dark mx-2"
                         onClick={() => deleteCharacterMove(characterMove.id)}
                          >
                          Delete
                          </button>
                        </form>
                </div>
            </div>
        </Container>
        </div>
  )
}
