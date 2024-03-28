import React from "react";
import { Container } from "react-bootstrap";


export default function ViewCharacter() {
  return (
    <div>
        <h1>
            Character Name
        </h1>

        <h2>
            Overview
        </h2>

        <h2>
            Top Moves
        </h2>

        <Container>
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
                        </tr>
                    </thead>
                </table>
            </div>
        </Container>
    </div>
  )
}
