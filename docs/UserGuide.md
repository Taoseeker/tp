---
layout: default.md
title: "User Guide"
pageNav: 3
---

# MedLogger User Guide 🏥

MedLogger is a **desktop app for managing contacts, optimized for use via a Command Line Interface (CLI)** while still benefiting from a Graphical User Interface (GUI). If you can type fast, MedLogger helps you complete contact management tasks **faster** than traditional GUI apps.

Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick Start

- Ensure you have **Java 17** or above installed on your computer.  
- **Mac users:** Follow the exact JDK installation steps mentioned [here](https://se-education.org/guides/tutorials/javaInstallationMac.html).

1. **Download** the latest `.jar` file from [here](https://github.com/se-edu/addressbook-level3/releases).
2. **Move** the file to the folder you want as the _home folder_ for MedLogger.
3. **Run MedLogger**:
    - Open a **command terminal**.
    - Navigate (`cd`) to the folder where the `.jar` file is located.
    - Run the following command:
      ```sh
      java -jar medlogger.jar
      ```
    - A GUI similar to the image below should appear in a few seconds:  
      ![UI](images/Ui.png)
    - The app will load with **sample data**.

4. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all contacts.

   * `add n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 d/2024-12-31 t/friends t/owesMoney` : Adds a contact named `John Doe` to the MedLogger.

   * `delete 3` : Deletes the 3rd contact shown in the current list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<box type="info" seamless></box>

**Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</box>

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a person: `add`

Adds a person to the Med Logger.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS d/DATE [t/TAG]…​`

<box type="tip" seamless></box>

**Tip:** A person can have any number of tags (including 0)
</box>

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 1, #02-24 d/2024-12-01`
* `add n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 d/2024-12-31 t/friends t/owesMoney`

### Remark a person : `remark`

Add a remark for a person from MedLogger.

Format: `remark INDEX r/REMARK`

* Add a remark for the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `remark 1 r/important`.

### Listing all persons : `list`

* `list`: Shows a list of all persons in the Med Logger.
* `list l/LIMIT`: Show a list of n `LIMIT` persons in the Med Loggers. 

Format: `list`

### Editing a person : `edit`

Edits an existing person in the Med Logger.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [d/DATE] [a/ADDRESS] [t/TAG]…​`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.

### Locating persons by name: `find`

Finds persons whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### Deleting a person : `delete`

Deletes the specified person from the Med Logger.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the Med Logger.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

### Clearing all entries : `clear`

Clears all entries from the Med Logger.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Exporting the data : `export`

Export the visits and persons data into either csv or json format. A save dialog will be prompted.

Format:
* `export csv`
* `export json`

### Saving the data

MedLogger data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

MedLogger data are saved automatically as a JSON file `[JAR file location]/data/medlogger.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless></box>

**Caution:**
If your changes to the data file makes its format invalid, MedLogger will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the MedLogger to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</box>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous MedLogger home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action     | Format, Examples
-----------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Add**    | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS d/DATE [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 d/2024-12-31 t/friend t/colleague`
**Remark**   | `remark INDEX r/REMARK`<br> e.g., `remark 1 r/important`
**Clear**  | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit**   | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [d/DATE] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find**   | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List**   | `list` or `list l/LIMIT`
**Help**   | `help`
