Smelly Mars Rover code refactoring
=============================================

Smelly Mars Rover code to practice refactoring.

We'll use it to learn to recognize some code smells
and to fix them applying some useful refactorings.

•	Poner nombre que se parezcan a los del enunciado.
•	El nombre de “testee” pude dar a confusion, usar mas exactos. 
•	Incluir el metodo ToString en las classes que se testeen porque cuando nos da un error Podemos tener mas informacion que no una simple direccion de memoria. 
•	Si queremos comparer dos objectos, lo major es implementar el metodo equals de este, asi en el test con una sola operacion Podemos hacer todos los cambios.
•	Utilizar la function Inline, lo qual nos permite hacer el inverso de Extraer un metodo de Codigo. Esta operacion nos deshace este metodo y nos lo vuelve a Codigo. De esta forma Podemos Volver a hacer un refactor 
https://www.jetbrains.com/help/idea/inline.html
•	


Cambis pendents: 
1.	Millorar el naming del codi - DONE
2.	Crear una funcio amb tots els if’s que es diguis process. DOne
3.	Fer els Nested If amb el que ens veurem clarament els codi repetit I podem fer un millor refactor amb Polimorfisme. 
4.	Em de pensar el cas en quants modificacions hauriem de fer si ens possesin un nova direcci’o a la Rover. 

KATA 2
Desmontar un if con una OR, en dos IF, cada uno con la condicion de una OR
Desmontar un if con else, cogiendo el else I convirtiendolo a if, con la condicion negada del primer if. 
Los switch se consideran code smell pq poden teniir que modificar moltes coses si ens demanen un canvi. 
Amb Polimorfisme treurem la duplicacio dels if’s
El problema es que el concept esta representat amb una primitive del llenguatge (no un objecte), ja que la direccio des un String. En Java no es pot (javascript si es pot p exemple). Llavors el primer es treure el code smell de “primitive obsession”  Ver Video https://www.youtube.com/watch?v=m26K5_msrs0&t=5s
1.	Crear nova estructura (Direction)
2.	Si volem canviar a sako, passara molta estona fins a passer els test. Hi ha una tecnica que es diu Narrowing change, per minimitzar la superficie de canvi. Encapusalte field. Dsp aplicarem el canvi en parallel, el que tirara de codi del nou I del vell. Vas al setter I sincronitces les dues coses (noves I velles). Llavors si llegim d’un o alters tindrem el matiex I podrem anar treient de l’antic fins a no fer lo servir. La clau aki es que cada moment pots anar executatnt
3.	En el video no fa servir el valueOf
El if es podria arribar a convertir en un map (molt extreme)
Dsp d’ha de fer un remove data clump
Refactoring to Pattern Joshua (tb te un video interessant)
Resum:
Teniem un metode amb motes responsabilitats (comentaris dins el codi per diferenciarles). 
Teniem falta de simetria amb els ifs
Duplicacio de condicionals (llavors si canvia una cosa ho em de canviar a tot arreu). Amb un sol if no hagues fet falta canvi
Al tenir que a condicio era un String (tipus primitiu), llavors haviem d’intorduir el “concepte”
I ens apareix el “feature envy”, pq tots volen anar cap alla. S;aplica el narrow change per poder fer test permanent (Encapsulate Fields…) 
Amb el polimorfisme de turn left I tright es un State Pattern. Pero amb els move no ho podem fer pq a vegades tornem una x o y (no es una interface comuna). Llavors s’ha de crear el concepte junt (Data clump) 

References:
1. Removing Primitive Obsession smell
https://www.youtube.com/watch?v=m26K5_msrs0&t=5s
2. Removing a data clump
https://www.youtube.com/watch?v=uV33Q9szres
3. Removing feature envy smell
https://www.youtube.com/watch?v=Z4qn57If5Zs
4. Replacing Conditional with Polymorphism
https://www.youtube.com/watch?v=tDYYLIhB2Fs (editado) 

The Limited Red Society, Joshua Kerievsky
https://www.youtube.com/watch?v=6u0GknnOLnc (editado) 
Examples lists in TDD
https://codesai.com/2018/03/examples-lists-in-tdd
TDD Guided by ZOMBIES
http://blog.wingman-sw.com/tdd-guided-by-zombies

Links
- Code Smells: Long Method
http://www.informit.com/articles/article.aspx?p=1400866&seqNum=2 
- Code Smells: Feature Envy
http://www.informit.com/articles/article.aspx?p=1400866&seqNum=7 
- Code Smells: Data Clumps
http://www.informit.com/articles/article.aspx?p=1400866&seqNum=8
- Code Smells: Primitive Obsession
http://www.informit.com/articles/article.aspx?p=1400866&seqNum=9 (editado) 09:35
- Code Smell: Case Statements
http://www.informit.com/articles/article.aspx?p=1400866&seqNum=10 (editado) 
- An example of introducing symmetry to enable duplication removal
https://codesai.com/2017/01/an-example-of-introducing-symmetry-to (editado) 
- Working efectively with legacy code
https://www.goodreads.com/book/show/44919.Working_Effectively_with_Legacy_Code

Kata 2
Passos realitzats: A cada iteració anem passant els test
1.	Passar de tenir un if – else a tenir dos if separats. La forma es canviar el que tenim al else i fer un if amb el la condicio negada del if que tenia abans el else. 
2.	Passar dels if que tenen la condicio amb una OR a dos if separats, amb la el mateix contingut. 
3.	Fet aquest pas el IDE ens marca que tenic Codi Duplicat, ja que em eliminat una possilitat, i repetim una comporvacio inecessaria. Eliminem codi duplicat. 
També trobarem condicionals repetits: command.equals(“r”) 
if (command.equals("r")) {
    // Rotate Rover
    if (direction.equals("N")) {
        if (command.equals("r")) {
            direction = "E";
        } else {
            direction = "W";
        }
    } else if (direction.equals("S")) {
        if (command.equals("r")) {
            direction = "W";
        } else {
            direction = "E";
        }
4.	Follow the video to apply Remove Primitive Obssession Smell
https://www.youtube.com/watch?v=m26K5_msrs0&t=5s
5.	Aplicar el polimofrisme per canviar el 	

6.	Removing a data clump
https://www.youtube.com/watch?v=uV33Q9szres
