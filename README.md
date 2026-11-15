## Odpowiedzi na pytania

### 1. Dlaczego rejestracja wyniku jest polem klasy, a nie znajduje się w obsłudze kliknięcia przycisku?

ActivityResultLauncher rejestrujemy w onCreate(), ponieważ musi być zarejestrowany przed uruchomieniem aktywności. Dzięki temu Android może poprawnie obsłużyć zwrócony wynik, również po odtworzeniu aktywności.

### 2. Co zobaczy ekran wywołujący, gdy użytkownik naciśnie na drugim ekranie przycisk Wstecz?

Po naciśnięciu przycisku Wstecz drugi ekran zostanie zamknięty i wrócimy do pierwszego ekranu. Nie pojawi się komunikat Toast, ponieważ wynik nie został ustawiony przez setResult(RESULT_OK). Pierwszy ekran pozostanie bez zmian, a wpisane wcześniej dane nadal będą widoczne.