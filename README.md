# questionnaire

rest api para listar una encuesta a los clientes

endpoint para crear la encuesta

POST  ```localhost:8080/questionnaire```
Body
```
[
    {
        "text": "cedula",
        "type": "SINGLE",
        "options": []
    },
    {
        "text": "nombre",
        "type": "SINGLE",
        "options": []
    },
    {
        "text": "Como calificaria nuestro servicio",
        "type": "MULTIPLE",
        "options": [
            {
                "text": "Malo",
            },
            {
                "text": "Regular",
            },
            {
                "text": "Aceptable",
            },
            {
                "text": "Bueno",
            },
            {
                "text": "Excelente",
            }
        ]
    }
]
```
el tipo de pregunta puede ser SINGLE (para una pregunta abierta), MULTIPLE (para una respuesta de opcion multiple).
----------------------------------------------------------------

enpoint para listar la encuesta 

GET ```localhost:8080/questionnaire```

return una lista con todas las preguntas de la encuesta
--------------------------------------------------------------

endpoint para almacenar una respuesta de la encuesta

POST ```localhost:8080/form```

### Body
```
    [
        {
            "question": "cedula",
            "answer": "12445"
        },
        {
            "question": "nombre",
            "answer": "12445"
        },
        {
            "question": "Como calificaria nuestro servicio",
            "answer": "Excelente"
        }
        
    ]

```

