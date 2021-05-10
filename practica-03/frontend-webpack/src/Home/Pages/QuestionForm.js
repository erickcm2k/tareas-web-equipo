import React, { useReducer } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import { Button, Flex, Heading, Stack, Text } from "@chakra-ui/react";
import { FormControl, FormLabel, Input } from "@chakra-ui/react";
const QuestionForm = () => {
  const id = new URLSearchParams(window.location.search).get("id");

  const initialValues = {
    question: "",
    questionName: "",
    answer: "",
    // drag1: "",
    // drag2: "",
    // drag3: "",
    // drag4: "",
    dragFile1: null,
    dragFile2: null,
    dragFile3: null,
    dragFile4: null,
    // target1: "",
    // target2: "",
    // target3: "",
    // target4: "",
    // targetFile1: null,
    // targetFile2: "",
    // targetFile3: "",
    // targetFile4: "",
  };

  const [formData, setFormData] = useReducer(
    (currentValues, newValues) => ({ ...currentValues, ...newValues }),
    initialValues
  );

  // const {
  //   questionName,
  //   question,
  //   answer,
  //   drag1,
  //   drag2,
  //   drag3,
  //   drag4,
  //   dragFile1,
  //   dragFile2,
  //   dragFile3,
  //   dragFile4,
  //   target1,
  //   target2,
  //   target3,
  //   target4,
  //   targetFile1,
  //   targetFile2,
  //   targetFile3,
  //   targetFile4,
  // } = formData;
  const {
    question,
    questionName,
    answer,
    dragFile1,
    dragFile2,
    dragFile3,
    dragFile4,
    // targetFile1,
    // targetFile2,
    // targetFile3,
    // targetFile4,
  } = formData;

  const handleFormChange = (event) => {
    const { name } = event.target;
    if (event.target.files) {
      const file = event.target.files[0];
      setFormData({ [name]: file });
    } else {
      const { value } = event.target;
      setFormData({ [name]: value });
    }
  };

  const submitForm = (e) => {
    e.preventDefault();
    let url = "";
    // Si hay un id, se trata de una nueva pregunta
    // sino, se modificara la pregunta con el id obtenido.
    !id
      ? (url = "http://localhost:8000/upload")
      : (url = `http://localhost:8000/upload?id=${id}`);
    
    const data = new FormData();
    data.append("file", dragFile1);
    data.append("file", dragFile2);
    data.append("file", dragFile3);
    data.append("file", dragFile4);
    data.append("questionName", questionName);
    data.append("question", question);
    data.append("answer", answer);
    // data.append("file", targetFile1);
    // data.append("file", targetFile2);
    // data.append("file", targetFile3);
    // data.append("file", targetFile4);

    axios
      .post(url, data, {})

      .then((res) => {
        console.log(res.statusText);
        console.log(formData);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <Stack spacing="3">
      <Heading size="xl">Ingrese los datos de la pregunta</Heading>
      <Text fontSize="xl">Es necesario llenar todos los campos.</Text>
      <form onSubmit={submitForm} encType="multipart/form-data">
        <FormControl paddingTop="4">
          <FormLabel>Nombre de la pregunta</FormLabel>
          <Input
            type="text"
            name="questionName"
            value={questionName}
            onChange={handleFormChange}
          />
        </FormControl>
        <FormControl>
          <FormLabel>Pregunta</FormLabel>
          <Input
            type="text"
            name="question"
            value={question}
            onChange={handleFormChange}
          />
        </FormControl>
        <FormControl>
          <FormLabel>Respuesta</FormLabel>
          <Input
            type="text"
            name="answer"
            value={answer}
            onChange={handleFormChange}
          />
        </FormControl>
        <Flex direction="row" paddingTop="5">
          <FormControl>
            <Heading size="lg" paddingBottom="4">
              Drags
            </Heading>
            {/* <Input
              placeholder="Drag 1"
              type="text"
              width="30%"
              name="drag1"
              value={drag1}
              onChange={handleFormChange}
              required
            ></Input> */}
            <input
              type="file"
              name="dragFile1"
              onChange={handleFormChange}
              required
            />
            {/* <Input placeholder="Drag 2" type="text" width="30%"></Input> */}
            <input
              type="file"
              name="dragFile2"
              onChange={handleFormChange}
              required
            />
            {/* <Input placeholder="Drag 3" type="text" width="30%"></Input> */}
            <input
              type="file"
              name="dragFile3"
              onChange={handleFormChange}
              required
            />
            {/* <Input placeholder="Drag 4" type="text" width="30%"></Input> */}
            <input
              type="file"
              name="dragFile4"
              onChange={handleFormChange}
              required
            />
          </FormControl>
          {/* <FormControl>
            <Heading size="lg" paddingBottom="4">
              Targets
            </Heading>
            <Input placeholder="Target 1" type="text" width="30%"></Input>
            <input
              type="file"
              name="targetFile1"
              onChange={handleFormChange}
              required
            />
            <Input placeholder="Target 2" type="text" width="30%"></Input>
            <input
              type="file"
              name="targetFile2"
              onChange={handleFormChange}
              required
            />
            <Input placeholder="Target 3" type="text" width="30%"></Input>
            <input
              type="file"
              name="targetFile3"
              onChange={handleFormChange}
              required
            />
            <Input placeholder="Target 4" type="text" width="30%"></Input>
            <input
              type="file"
              name="targetFile4"
              onChange={handleFormChange}
              required
            />
          </FormControl> */}
        </Flex>
        <Link to="/">
          <Button m="4" colorScheme="blue" type="submit">
            Volver
          </Button>
        </Link>
        <Button m="4" colorScheme="teal" type="submit">
          Subir cambios
        </Button>
      </form>
    </Stack>
  );
};

export default QuestionForm;
