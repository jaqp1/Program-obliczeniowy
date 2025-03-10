# Symulacja Ruchu

## Opis projektu
Projekt to symulacja ruchu obiektu, która wykorzystuje różne metody numeryczne do obliczania trajektorii. Program pozwala na wybór metody rzędu pierwszego, drugiego lub czwartego, a także na konfigurację parametrów początkowych takich jak czas końcowy, kąt początkowy i prędkość początkowa.

## Funkcje
- Wybór metody numerycznej (pierwszego, drugiego lub czwartego rzędu).
- Konfiguracja parametrów symulacji.
- Zapis wyników do prawego panelu, okna konsoli tekstowej lub pliku `result.txt`.

## Użycie
1. Skonfiguruj parametry symulacji w pliku konfiguracyjnym.
2. Wybierz metodę numeryczną.
3. Uruchom program, aby uzyskać wyniki symulacji.
4. Wyniki można zapisać w wybranym miejscu (panel, konsola, plik).

## Przykładowe wyniki
Program generuje wyniki w formie tabeli, która zawiera czas, kąt (alfa) i prędkość kątową (omega) w kolejnych krokach czasowych.
![App Screenshot](https://github.com/jaqp1/Program-obliczeniowy/blob/master/Zrzut%20ekranu%202025-02-25%20203326.png?raw=true)

## Wymagania
- Java 8 lub nowsza.

## Instalacja
1. Sklonuj repozytorium.
2. Skompiluj projekt za pomocą narzędzia Maven lub bezpośrednio w IDE.
3. Uruchom plik `Main.java`.

