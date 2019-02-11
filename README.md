3.a) For the patterns listing in Step3, which are architectural patterns and which are design
patterns? What are the relationships and differences of architectural patterns and design
patterns?
Design patterns: Observer, State, Template methods, Abstract factory, Pipe and filter.
Architectural: Model View Controller.

Design patterns are more on the code level while the Architecture Pattern describes more how the entire project is set up.
It is difficult to change an architectural pattern after having worked on the code.

3.b) How is the pattern you chose realized in your code? (Which class(es) works as the
pattern you chose?)
I chose the Observer pattern. This is realised in Ball, PaddleLeft and PaddleRight in the form of function calls of the
setChanged() and notifyObservers() functions.
The observer class is the "GameObserver" which contains three objects that keeps track of the observables values.
In the class "PlayState" the GameObserver is set to be an observer of the observables.
3.c) Is there any advantages in using this pattern in this program? (What are the
advantages/disadvantages?)
After i made this code i realised some advantages i could have implemented. Particularly if this was a game of several states.
I should have observed the "score" of playstate and used the gameObserver to change states based on the score.
I cant see any disadvantages as long as it is kept simple.
