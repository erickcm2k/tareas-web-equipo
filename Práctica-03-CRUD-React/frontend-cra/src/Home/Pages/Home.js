import React from "react";
import {
  Table,
  Thead,
  Tbody,
  Tr,
  Th,
  Td,
  TableCaption,
} from "@chakra-ui/react";
import { Text } from "@chakra-ui/react";
import { Button } from "@chakra-ui/react";
import {
  AlertDialog,
  AlertDialogBody,
  AlertDialogFooter,
  AlertDialogHeader,
  AlertDialogContent,
  AlertDialogOverlay,
} from "@chakra-ui/react";
import { Link } from "react-router-dom";

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
  const [isOpen, setIsOpen] = React.useState(false);
  const onClose = () => setIsOpen(false);
  const cancelRef = React.useRef();

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
          {data.map((e) => {
            return (
              <Tr key={e.id}>
                <Td>{e.text}</Td>
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
                    onClick={() => setIsOpen(true)}
                  >
                    Borrar
                  </Button>
                </Td>
              </Tr>
            );
          })}
        </Tbody>

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
                <Button colorScheme="red" onClick={onClose} ml={3}>
                  Borrar
                </Button>
              </AlertDialogFooter>
            </AlertDialogContent>
          </AlertDialogOverlay>
        </AlertDialog>
      </Table>
    </>
  );
};

export default Home;
