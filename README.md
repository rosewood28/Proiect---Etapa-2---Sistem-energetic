# Proiect Energy System Etapa 2

## Despre

Proiectare Orientata pe Obiecte, Seriile CA, CD
2020-2021

<https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/proiect/etapa2>

Student: Stan Sabina, 321CD

## Rulare teste

Clasa Test#main
  * ruleaza solutia pe testele din checker/, comparand rezultatele cu cele de referinta
  * ruleaza checkstyle

Detalii despre teste: checker/README

Biblioteci necesare pentru implementare:
* Jackson Core 
* Jackson Databind 
* Jackson Annotations

Tutorial Jackson JSON: 
<https://ocw.cs.pub.ro/courses/poo-ca-cd/laboratoare/tutorial-json-jackson>

## Implementare

### Entitati

Pentru citire si scriere am folosit clasele din pachetele 'input' si 'output' 
care au aceleasi campuri ca cele din fisierele de intrare/iesire.
Pentru implementare am folosit clasele din pachetul entities in care am 
adaugat orice campuri de care am avut nevoie.

### Flow

Clasa care controleaza flowul este clasa Main.

In runda initiala: 
-se aleg producatorii
-se alege cel mai bun distribuitor
-consumatorii primesc salariu
-se creaza contracte
-consumatorii platesc catre distribuitori
-distribuitorii platesc cheltuielile.

In urmatoarele runde:
-se citesc update-uri
-se adauga noi consumatori
-se actualizeaza preturile distribuitorilor
-se alege cel mai bun distribuitor
-consumatorii primesc salariu
-se sterg contractele invalide sau expirate
-se intocmesc noi contracte
-consumatorii platesc catre distribuitori
-distribuitorii platesc cheltuielile
-se actualizeaza cantitatea de energie a producatorilor
-se notifica observatorii si se reaplica strategia distribuitorilor (care
au fost la unul dintre producatorii care au avut update)
-se reține câți distribuitori a avut fiecare producător in monthlyStat
-se decrementeaza numarul de runde.

Entitatile comunica intre ele prin campuri "de legatura" care se afla in fiecare clasa si care 
contin elemente comune celor doua clase care doresc sa aiba informatii una despre cealalta, 
de exemplu: 'contracts' din 'Distributor' si 'contract' din 'Consumer' sau lista de 
distribuitori si clasa 'Producer' si lista de producatori din clasa 'Distributor'.

### Design patterns

Am folosit design patternul Strategy pentru a implementa alegerea pe care fiecare distribuitor 
o face cand isi alege producatorul. Astfel, cele trei tipuri de strategii implementeaza metoda 
de sortare a listei de producatori data ca paramentru metodei 'apply' din interfata Strategy.
In metoda SortByStrategy se sorteaza lista in functie de distribuitorul care solicita sortarea
si de strategia aleasa de acesta. In clasele 'ChooseProducer' si 'DistributorReaply' se 
stabileste cati producatori  din lista sortata trebuie sa aleaga distribuitorul pentru a obtine
intreaga cantintate necesara de energie.

Am folosit Observer pentru a stabili cand se realeg producatorii pentru fiecare distribuitor. 
Clasa Producer din pachetul entities este observer si clasa ProducerChanges este clasa Subiect.
In fiecare runda verific daca am schimbari pentru producatori si daca am, notific observatorii
care se afla in listele de distribuitori ale producatorilor care au un update in runda curenta.

### Dificultati intalnite, limitari, probleme

- \src\entities\Producer.java:26:66: 'producerChanges' hides a field. [HiddenField]
Pentru a rezolva aceasta problema de checkstyle am redenumit campul
'producerChanges' dat ca parametru cu 'pProducerChanges' astfel incat acesta 
sa difere de campul din clasa Producer.
-\src\methods\ConsumersPay.java:26:56: '1.2' is a magic number. [MagicNumber]
Pentru a elimina aceasta eroare de checkstyle am adaugat o constanta de tip final
egala cu 1,2.
-\src\newmethods\SortByStrategy.java:24:37: Inner assignments should be avoided. [InnerAssignment]
Rezolvarea acestei probleme consta in a inlocui switch cu if.

[optional ## Feedback, comments
Tema a fost bine structurata si a avut un enunt mai clar in comparatie cu prima etapa.

