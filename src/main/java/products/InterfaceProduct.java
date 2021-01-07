package products;

import account.FacadeAccount;

public interface InterfaceProduct {
     void wyswietl();

     void ustaw();

     String nazwa();

     String kategoria();

     double cena();

     int ilosc();

     void ustawIlosc();

     FacadeAccount konto();
}