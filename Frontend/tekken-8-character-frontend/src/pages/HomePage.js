import React from 'react'
import { Container } from 'react-bootstrap'

export default function HomePage() {
  return (
    <div>
       
        <Container>
          <h2 className="text-center m-4">Characters</h2>
            <div className="py-4">
                <table className="table table-bordered border-rounded table-dark table-stripped">
                    <thead>
                        <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Fight Style</th>
                        <th scope="col">Height</th>
                        <th scope="col">Weight</th>
                        <th scope="col">Nationality</th>
                        </tr>
                    </thead>
                </table>
            </div>
        </Container>
    </div>
  )
}
