## Medical Consulting App

#### Aplicatia are ca scop administrarea programarilor/consultatiilor medicale a unui lant de spitale.



## Entitati
- Asigurare
  - id (int)
  - tipAsigurare (String)
  - numeCasaSanatate (String)
  
- Cabinet
  - number (int)
  - hasBed (boolean)

- Diagnostic
  - urgenta (int)
  - diagnostic (int)

- Doctor 
  - id (int)
  - nume (String)
  - spital (Spital)
  - cabinet (Cabinet)

- Pacient 
  - id (int)
  - nume (String)
  - programari [] (Lista de obiecte de tip Programare)
  - asigurare (Asigurare)
  - diagnostic (Diagnostic)
  
- Programare
  - ora (int)
  - zi (int)
  - luna (int)
  - doctor (Doctor)
- Spital
  - id (int)
  - nume (String)
  - adresa (String)
  - triaj (Triaj)

- Triaj
  - number (int)
  - sefTriaj (int)
  
  
  ## Servicii
- Serviciul pt Asigurare
  - scriere/citire in CSV
- Cabinet
  - scriere/citire in CSV
- Diagnostic
  - scriere/citire in CSV
- Triaj 
  - scriere/citire in CSV
- Doctor
- Pacient


  
