/// @file ModificaContattoController.java
/// @brief Definisce la classe ModificaContattoController per la gestione delle operazioni di modifica e creazione di un contatto.
///
/// La classe `ModificaContattoController` fornisce metodi per aggiungere, modificare e annullare operazioni
/// sui contatti nella rubrica. Gestisce le modifiche ai dati di un contatto e la possibilità di annullare
/// operazioni in corso.

package controller;

import model.*;
import ui.*;

/// @class ModificaContattoController
/// @brief Controller per la classe `ModificaContatto` del package `ui`.
///
/// La classe ModificaContattoController fornisce metodi per interagire con la rubrica dei contatti,
/// consentendo di aggiungere un nuovo contatto, modificare i dati di un contatto esistente, e annullare
/// le operazioni in corso.
public class ModificaContattoController {
    private Contatto vecchio; ///< Il contatto originale da modificare, o `null` se si sta creando un nuovo contatto.

    /// @brief Costruttore del controller.
    /// @param vecchio Il contatto da modificare (null se si sta creando un nuovo contatto).
    ///
    /// Inizializza il controller.
    public ModificaContattoController(Contatto vecchio) {
        this.vecchio = vecchio;
    }

    /// @brief Restituisce il contatto attualmente in modifica.
    /// @return Il contatto originale da modificare, o `null` se si sta creando un nuovo contatto.
    public Contatto getContatto() {
        return vecchio;
    }

    /// @brief Aggiunge un nuovo contatto alla rubrica.
    /// @param contatto Il contatto da aggiungere alla rubrica.
    ///
    /// Questo metodo aggiunge il contatto appena creato alla rubrica,
    /// poi passa alla schermata di visualizzazione del contatto
    /// appena aggiunto.
    public void aggiungi(Contatto contatto) {
        Rubrica.aggiungi(contatto);
        Finestra.mostraContatto(contatto);
    }

    /// @brief Modifica un contatto esistente nella rubrica.
    /// @param nuovo Il contatto con i nuovi dati da applicare.
    ///
    /// Questo metodo aggiorna un contatto già esistente nella rubrica,
    /// sostituendo il contatto originale con quello modificato,
    /// poi passa alla schermata di visualizzazione del contatto
    /// appena modificato.
    public void modifica(Contatto nuovo) {
        Rubrica.modifica(vecchio, nuovo);
        Finestra.mostraContatto(nuovo);
    }

    /// @brief Annulla l'operazione in corso.
    ///
    /// Questo metodo verifica se si sta creando un contatto o
    /// modificando uno esistente, quindi sceglie il metodo
    /// corretto per passare alla giusta schermata.
    public void annulla() {
        if (vecchio == null)
            annullaCreazione();
        else
            annullaModifica();
    }

    /// @brief Annulla la modifica di un contatto esistente.
    ///
    /// Questo metodo annulla la modifica in corso,
    /// ripristinando lo stato precedente della rubrica,
    /// senza apportare modifiche al contatto.
    private void annullaModifica() {
        Finestra.mostraContatto(vecchio);
    }

    /// @brief Annulla la creazione di un nuovo contatto.
    ///
    /// Questo metodo annulla la creazione in corso,
    /// ripristinando lo stato precedente della rubrica,
    /// senza apportare modifiche a essa.
    private void annullaCreazione() {
        Finestra.mostraVediRubrica(Rubrica.getContatti());
    }

}