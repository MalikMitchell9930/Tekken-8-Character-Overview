import React, { useState } from "react";
import axios from "axios";
import { Container } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";

export default function AddCharacter() {
  let navigate = useNavigate();

  const[character,setCharacter] = useState({
    tekkenCharacterName:"",
    fightStyle: "",
    height: "",
    weight: "",
    nationality: "",
    overview: "",
  });

  const{tekkenCharacterName, fightStyle, height, weight, nationality, overview} = character;

  const onInputChange = (e) => {
    setCharacter({...character,[e.target.name]: e.target.value});
  };

  const onSubmit = async(e) =>{
    e.preventDefault();
    await axios.post("http://localhost:8080/overview/character",character);
    navigate("/");
  };
  return (
    <div>
        <Container>
            <div className="row">
                <div className="col-md-8 offset-md-2 border rounded p-4 mt-2 shadow bg-light">
                    <h2 className="text-center m-4">
                        Add Character
                        </h2>
                        <form onSubmit={(e) => onSubmit(e)}>
                        <div className="mb-3">
                          <label htmlFor="CharacterName" className="form-label">
                            Character Name
                          </label>
                          <input
                          type={"text"}
                          className="form-control"
                          placeholder="Enter the Character's Name"
                          name="tekkenCharacterName"
                          value={tekkenCharacterName}
                          onChange={(e) => onInputChange(e)}
                          />
                        </div>

                        <div className="mb-3">
                          <label htmlFor="FightStyle" className="form-label">
                            Fight Style
                          </label>
                          <input
                          type={"text"}
                          className="form-control"
                          placeholder="Enter the Character's Fight Style"
                          name="fightStyle"
                          value={fightStyle}
                          onChange={(e) => onInputChange(e)}
                          />
                        </div>

                        <div className="mb-3">
                          <label htmlFor="Height" className="form-label">
                            Height(cm)
                          </label>
                          <input
                          type={"text"}
                          className="form-control"
                          placeholder="Enter the Character's Height in cm"
                          name="height"
                          value={height}
                          onChange={(e) => onInputChange(e)}
                          />
                        </div>

                        <div className="mb-3">
                          <label htmlFor="Weight" className="form-label">
                            Weight(kg)
                          </label>
                          <input
                          type={"text"}
                          className="form-control"
                          placeholder="Enter the Character's Weight in kg"
                          name="weight"
                          value={weight}
                          onChange={(e) => onInputChange(e)}
                          />
                        </div>

                        <div className="mb-3">
                          <label htmlFor="Nationality" className="form-label">
                            Nationality
                          </label>
                          <input
                          type={"text"}
                          className="form-control"
                          placeholder="Enter the Character's Nationality"
                          name="nationality"
                          value={nationality}
                          onChange={(e) => onInputChange(e)}
                          />
                        </div>

                        <div className="mb-3">
                          <label htmlFor="Summary" className="form-label">
                            Character Summary
                          </label>
                          <div>
                          <textarea
                          rows="15"
                          cols="70"
                          wrap="soft"
                          placeholder="Enter the Character's Overview Summary"
                          name="overview"
                          value={overview}
                          onChange={(e) => onInputChange(e)}
                          >
                          </textarea>
                          </div>
                        </div>
                        <Link className="btn btn-outline-danger mx-2" to="/">
                          Cancel
                        </Link>
                        <button type="submit" className="btn btn-outline-primary">
                          Submit
                        </button>
                        </form>
                </div>
            </div>
        </Container>
    </div>
  )
}
