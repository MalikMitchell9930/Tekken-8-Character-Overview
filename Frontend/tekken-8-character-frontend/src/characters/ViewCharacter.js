import React, {useEffect, useState} from "react";
import { Container } from "react-bootstrap";
import axios from "axios";
import { Link,useNavigate, useParams } from "react-router-dom";



export default function ViewCharacter() {
    let navigate = useNavigate();
    const { id } = useParams();
    const {tekkenCharacterId} = useParams();

    
    const [characterMoves , setCharacterMoves] =useState([])

    useEffect(()=>{
        loadCharacterMoves()
    },[]);
    
    const loadCharacterMoves=async()=>{
        const result = await axios.get(`http://localhost:8080/overview/characters/${id}/moves`)
        setCharacterMoves(result.data);
    }
    
    const [character, setCharacter] = useState({
        tekkenCharacterName: "",
        fightStyle: "",
        height: "",
        weight: "",
        nationality: "",
        overview: "",
      });
    
      useEffect(() => {
        loadCharacter();
      }, []);
    
      const loadCharacter = async () => {
        const result = await axios.get(`http://localhost:8080/overview/characters/${id}`);
        setCharacter(result.data);
        };

        const deleteCharacter = async (id) => {
            await axios.delete(`http://localhost:8080/overview/characters/${id}`);
            navigate("/");
        };
     
  return (
    <div>
        <Container>
        <h1>
            {character.tekkenCharacterName}
        </h1>
        <div>
        <img src={`/CharacterImages/${character.tekkenCharacterName}.jpg`}
        alt="character" 
        height="700px"
        width="500px"
        />
        </div>
        <h2>
            Overview
        </h2>
        <div>
            {character.overview}
        </div>

        <h2>
            Top Moves
        </h2>

        
            <div className="py-4">
                <table className="table table-bordered border-rounded table-dark table-stripped">
                    <thead>
                        <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Annotation</th>
                        <th scope="col">Hit Properties</th>
                        <th scope="col">Startup Frames</th>
                        <th scope="col">On Hit</th>
                        <th scope="col">On Block</th>
                        <th scope="col">On Counter Hit</th>
                        <th scopre="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            characterMoves.map((characterMove,index)=>(
                                <tr>
                                    <td>{characterMove.moveName}</td>
                                    <td>{characterMove.annotation}</td>
                                    <td>{characterMove.hitLevel}</td>
                                    <td>{characterMove.startupFrames}</td>
                                    <td>{characterMove.onHit}</td>
                                    <td>{characterMove.onBlock}</td>
                                    <td>{characterMove.onCounterHit}</td>
                                    <td>
                                        <Link
                                        to={`/editCharacterMove/${characterMove.id}`}
                                        >
                                            View
                                        </Link>
                                    </td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
            <Link 
            className="btn text-light bg-dark"
            to = {`/addCharacterMove/${character.id}`}
            >
                Add Character Move
            </Link>

            <Link 
            className="btn text-light bg-dark"
            to={`/editCharacter/${character.id}`}
            >
                Edit
            </Link>

            <button 
            className="btn text-light bg-dark"
            onClick={() => deleteCharacter(character.id)}
            >
                Delete
            </button>
        </Container>
    </div>
  )
}
