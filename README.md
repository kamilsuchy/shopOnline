# ShopOnline
Aplikacja zapewnia funkcjonalności, które mają pomagać przy dokonywaniu zakupów w sklepie,
wprowadzone są również konta dla administratorów, którzy mogą moderować ogłoszenia.

### Podstawowe funkcjonalności

#### ```Konto Klienta```
- kupowanie przedmiotów z ogłoszeń
- dodawanie nowych ogłoszeń (na podstawie już istniejących lub całkowicie nowych)
- przeglądanie historii własnych zamówień
- doładowanie konta
- przeglądanie wszystkich ofert (według kategorii lub według nazwy)

#### ```Konto Admina```
- zmiana stanu użytkownika (użytkownik może mieć jeden z czterech stanów: `NEW`, `ACTIVE`, `BLOCKED`, `BANNED`)
- usuwanie ogłoszeń

### Wykorzystane wzorce projektowe
- `Command` - wykorzystany w klasie Register, traktuje żądanie zalogowania lub rejestracji jako obiekt, a także sprawdza, czy użytkownik może zostać zalogowany/zarejestrowany  
- `Dekorator` - zastosowany do różnego wypisywania stopki podczas drukowania rachunku po zakupach
- `Dependency Injection` - wzorzec zastosowany w celu wstrzyknięcia zależności służącej do obliczania rabatu (w klasie Order)
- `Adapter` - rolę adaptera pełni klasa AdapterProductCategoryTicket
- `Singleton` - klasa ShopOnline, Offers i WebUsers są singletonami
- `Iterator` - implementowany przez klasę HistoryIterator
- `Fasada` - rolę fasady pełni klasa Register, która zapewnia dostęp do systemu klasie głównej
- `Strategia` - implementowany przez package discount, wykorzystywany, aby elastycznie stosować różne algorytmy obliczania zniżki
- `Fabryka` - wzorzec zastosowany w celu uporządkowanego tworzenia nowych ofert, zaimplementowany w package offerFactory
- `Prototyp` - jedną z funkcjonalności jest tworzenie nowych ogłoszeń na podstawie już istniejących, dlatego konieczne było zapewnienie klonowalności dla każdego produktu, do czego wykorzystany został wzorzec prototype
