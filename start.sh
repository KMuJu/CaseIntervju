#!/bin/sh

# '{"navn":"Toppkasko","beskrivelse":"","inkluderer":[],"pris":0}'
# '{"navn":"Kasko med leiebil","beskrivelse":"En forsikring som passer de fleste biler. Dekker for det meste av skader, også de du selv er ansvarlig for.","inkluderer":[{"navn":"Minikasko","beskrivelse":"","inkluderer":[],"pris":0}'
# '{"navn":"Ansvar","beskrivelse":"","inkluderer":[],"pris":0}],"pris":117900}'
# '{"navn":"Kasko","beskrivelse":"","inkluderer":[],"pris":0}'
# '{"navn":"Minikasko","beskrivelse":"","inkluderer":[],"pris":0}'
# '{"navn":"Ansvar","beskrivelse":"","inkluderer":[],"pris":0}'

# curl -X PUT -H "Content-Type: application/json" -d '{"navn":"Toppkasko","beskrivelse":"","inkluderer":[],"pris":1}' http://localhost:8080/dekning
# curl -X PUT -H "Content-Type: application/json" -d '{"navn":"Ansvar","beskrivelse":"","inkluderer":[],"pris":1}' http://localhost:8080/dekning
# curl -X PUT -H "Content-Type: application/json" -d '{"navn":"Kasko","beskrivelse":"","inkluderer":[],"pris":1}' http://localhost:8080/dekning
# curl -X PUT -H "Content-Type: application/json" -d '{"navn":"Minikasko","beskrivelse":"","inkluderer":[],"pris":1}' http://localhost:8080/dekning
# curl -X PUT -H "Content-Type: application/json" -d '{"navn":"Ansvar","beskrivelse":"","inkluderer":[],"pris":1}' http://localhost:8080/dekning
# curl -X PUT -H "Content-Type: application/json" -d '{"navn":"Kasko med leiebil","beskrivelse":"En forsikring som passer de fleste biler. Dekker for det meste av skader, også de du selv er ansvarlig for.","inkluderer":[{"navn":"Minikasko","beskrivelse":"","inkluderer":[],"pris":1}],"pris":1}' http://localhost:8080/dekning


curl -X PUT -H "Content-Type: application/json" -d \
'{
    "navn":"Ansvar",
    "beskrivelse":"Obligatorisk når du eier et kjøretøy som er i bruk på offentlig vei.",
    "inkluderer":[],
    "dekninger":["ANSVAR"],
    "pris":362
}' http://localhost:8080/admin/forsikring

curl -X PUT -H "Content-Type: application/json" -d \
'{
    "navn":"Minikasko",
    "beskrivelse":"Egner seg for eldre biler med en verdi under 50 000 kr. Inkluderer dekning for brann, tyveri og glasskader, i tillegg til det obligatoriske ansvaret.",
    "inkluderer":[],
    "dekninger":["ANSVAR","VEIHJELP"],
    "pris":491
}' http://localhost:8080/admin/forsikring

curl -X PUT -H "Content-Type: application/json" -d \
'{
    "navn":"Kasko",
    "beskrivelse":"Kasko dekker det lovpålagte ansvaret, veihjelp ved uhell, skader på egen bil, samt mulighet for leiebil mens bilen din er på verksted.",
    "inkluderer":[],
    "dekninger":["ANSVAR","VEIHJELP","SKADE_EGEN_BIL"],
    "pris":1123
}' http://localhost:8080/admin/forsikring

curl -X PUT -H "Content-Type: application/json" -d \
'{
    "navn":"Kasko med leiebil",
    "beskrivelse":"En forsikring som passer de fleste biler. Dekker det meste av skader, også de du selv er ansvarlig for.",
    "inkluderer":[ 1, 2 ],
    "dekninger":["ANSVAR","VEIHJELP","SKADE_EGEN_BIL","LEIEBIL"],
    "pris":1179
}' http://localhost:8080/admin/forsikring

curl -X PUT -H "Content-Type: application/json" -d \
'{
    "navn":"Toppkasko",
    "beskrivelse":"Egner seg for biler med høy verdi, særlig hvis bilen er under 10 år gammel. Inkluderer dekning for maskinskader.",
    "inkluderer":[],
    "dekninger":["ANSVAR","VEIHJELP","SKADE_EGEN_BIL","LEIEBIL","MASKINSKADE"],
    "pris":1235
}' http://localhost:8080/admin/forsikring
