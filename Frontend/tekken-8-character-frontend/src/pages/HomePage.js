import React, { useEffect, useState } from 'react'
import { Container } from 'react-bootstrap'
import axios from 'axios';
import { useParams } from 'react-router-dom';
import { Link } from 'react-router-dom';

export default function HomePage() {

    const [characters , setCharacters] =useState([])

    const{id} = useParams();

    useEffect(()=>{
        loadCharacters()
    },[]);
    const loadCharacters=async()=>{
        const result = await axios.get("http://localhost:8080/overview/characters")
        setCharacters(result.data);
    }
  return (
    <div>
       
        <Container>
          <h2 className="text-center m-4">
            Characters
            </h2>
            <div className="py-4">
                <table className="table table-bordered border-rounded table-dark table-stripped">
                    <thead>
                        <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Fight Style</th>
                        <th scope="col">Height(cm)</th>
                        <th scope="col">Weight(kg)</th>
                        <th scope="col">Nationality</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            characters.map((character,index)=>(
                                <tr>
                                    <Link component="td"
                                     scope ="row"
                                     key={character.tekkenCharacterName}
                                     to={`/viewCharacter/${character.id}`}>
                                        {character.tekkenCharacterName}
                                    </Link>
                                    <td>{character.fightStyle}</td>
                                    <td>{character.height}</td>
                                    <td>{character.weight}</td>
                                    <td>{character.nationality}</td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </Container>
    </div>
  )
}
