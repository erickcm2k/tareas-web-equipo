import React from "react";
import { Flex, Heading, Stack } from "@chakra-ui/react";
import {
  FormControl,
  FormLabel,
  FormErrorMessage,
  Input,
  FormHelperText,
} from "@chakra-ui/react";
const QuestionForm = () => {
  return (
    <Stack spacing="3">
      <Heading size="xl">Ingrese los datos de la pregunta</Heading>
      <FormControl>
        <FormLabel>Nombre de la pregunta</FormLabel>
        <Input type="text" />
      </FormControl>
      <FormControl>
        <FormLabel>Pregunta</FormLabel>
        <Input type="text" />
      </FormControl>
      <FormControl>
        <FormLabel>Respuesta</FormLabel>
        <Input type="text" />
      </FormControl>
      <Flex direction="row">
        <FormControl>
          <Heading size="lg">Drags</Heading>
          <FormLabel>Drag 1</FormLabel>
          <input type="file" />
          <FormLabel>Drag 2</FormLabel>
          <input type="file" />
          <FormLabel>Drag 3</FormLabel>
          <input type="file" />
          <FormLabel>Drag 4</FormLabel>
          <input type="file" />
        </FormControl>
        <FormControl>
          <Heading size="lg">Targets</Heading>
          <FormLabel>Target 1</FormLabel>
          <input type="file" />
          <FormLabel>Target 2</FormLabel>
          <input type="file" />
          <FormLabel>Target 3</FormLabel>
          <input type="file" />
          <FormLabel>Target 4</FormLabel>
          <input type="file" />
        </FormControl>
      </Flex>
    </Stack>
  );
};

export default QuestionForm;
