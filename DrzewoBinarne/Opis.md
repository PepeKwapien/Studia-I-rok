### Drzewo Binarne
Proste drzewo binarne przechowujące wartości int (wartości się nie powtarzają).  
Drzewo posiada funkcjonalności standardowego drzewa binarnego (usuwanie, wyszukiwanie węzła itd.)  
Ponadto drzewo jest zaopatrzone w klasę pomocniczą "Pchła", która służy do przechodzenia po drzewie w określony sposób (w zależności od trybu pchły przechodzimy pre-,post-,inorder).  
Jeśli zmieniamy drzewo pchły są "zabijane" i nie można z nich korzystać - odpowiednik wyrzucenia ConcurrentModificationException.
