import React from "react";
import axios from "axios";
import { Container } from "react-bootstrap";

export default function AddCharacter() {
  return (
    <div>
        <Container>
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">
                        Add Character
                        </h2>
                </div>
            </div>
        </Container>
    </div>
  )
}
