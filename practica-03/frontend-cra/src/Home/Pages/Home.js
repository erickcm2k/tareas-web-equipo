import React, { useState, useRef } from "react";
import { Link } from "react-router-dom";
import {
  Table,
  Thead,
  Tbody,
  Tr,
  Th,
  Td,
  TableCaption,
  AlertDialog,
  AlertDialogBody,
  AlertDialogFooter,
  AlertDialogHeader,
  AlertDialogContent,
  AlertDialogOverlay,
} from "@chakra-ui/react";
import { Text } from "@chakra-ui/react";
import { Button } from "@chakra-ui/react";
import axios from "axios";
const data = [
  {
    text:
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
    id: 1,
  },
  {
    text:
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
    id: 2,
  },
  {
    text:
      "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
    id: 3,
  },
];

const Home = () => {
  const [isOpen, setIsOpen] = useState(false);
  const onClose = () => setIsOpen(false);
  const cancelRef = useRef();
  const [idToEliminate, setIdToEliminate] = useState(null);

  const deleteQuestion = () => {
    console.log(`Pregunta ${idToEliminate} está siendo eliminada.`);
    // Usar hasta que esté lista la ruta de eliminar.
    // await axios
    //   .delete(http://localhost:8000, { id })
    //   .then((res) => {
    //     console.log(res);
    //   })
    //   .catch((err) => {
    //     console.log(err);
    //   });
  };

  return (
    <>
      <Text fontSize="6xl">CRUD</Text>
      <Link to="create">
        <Button colorScheme="blue">Crear nueva pregunta</Button>
      </Link>
      <Table variant="striped">
        <TableCaption>Lista de preguntas</TableCaption>
        <Thead>
          <Tr>
            <Th>Pregunta</Th>
            <Th>Acciones</Th>
          </Tr>
        </Thead>
        <Tbody>
          {data.map((e, index) => {
            return (
              <Tr key={e.id}>
                <Td>
                  {Number(index + 1)}.- {e.text}
                </Td>
                <Td>
                  <Link to={`see?id=${e.id}`}>
                    <Button colorScheme="green" size="md">
                      Ver
                    </Button>
                  </Link>
                </Td>
                <Td>
                  <Link to={`modify?id=${e.id}`}>
                    <Button colorScheme="yellow" size="md">
                      Modificar
                    </Button>
                  </Link>
                </Td>
                <Td>
                  <Button
                    colorScheme="red"
                    size="md"
                    onClick={() => {
                      setIsOpen(true);
                      setIdToEliminate(e.id);
                    }}
                  >
                    Borrar
                  </Button>
                </Td>
              </Tr>
            );
          })}
        </Tbody>
      </Table>
      <AlertDialog
        isOpen={isOpen}
        leastDestructiveRef={cancelRef}
        onClose={onClose}
      >
        <AlertDialogOverlay>
          <AlertDialogContent>
            <AlertDialogHeader fontSize="lg" fontWeight="bold">
              Borrar pregunta
            </AlertDialogHeader>

            <AlertDialogBody>
              ¿Realmente desea borrar la pregunta?
            </AlertDialogBody>

            <AlertDialogFooter>
              <Button ref={cancelRef} onClick={onClose}>
                Cancelar
              </Button>
              <Button
                colorScheme="red"
                onClick={() => {
                  deleteQuestion();
                  onClose();
                }}
                ml={3}
              >
                Borrar
              </Button>
            </AlertDialogFooter>
          </AlertDialogContent>
        </AlertDialogOverlay>
      </AlertDialog>
    </>
  );
};

export default Home;
