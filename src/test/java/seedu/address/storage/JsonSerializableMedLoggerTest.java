package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.MedLogger;
import seedu.address.testutil.TypicalPersons;

public class JsonSerializableMedLoggerTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableMedLoggerTest");
    private static final Path TYPICAL_PERSONS_FILE = TEST_DATA_FOLDER.resolve("typicalPersonsMedLogger.json");
    private static final Path INVALID_PERSON_FILE = TEST_DATA_FOLDER.resolve("invalidPersonMedLogger.json");
    private static final Path DUPLICATE_PERSON_FILE = TEST_DATA_FOLDER.resolve("duplicatePersonMedLogger.json");

    @Test
    public void toModelType_typicalPersonsFile_success() throws Exception {
        JsonSerializableMedLogger dataFromFile = JsonUtil.readJsonFile(TYPICAL_PERSONS_FILE,
                JsonSerializableMedLogger.class).get();
        MedLogger medLoggerFromFile = dataFromFile.toModelType();
        MedLogger typicalPersonsMedLogger = TypicalPersons.getTypicalMedLogger();
        assertEquals(medLoggerFromFile, typicalPersonsMedLogger);
    }

    @Test
    public void toModelType_invalidPersonFile_throwsIllegalValueException() throws Exception {
        JsonSerializableMedLogger dataFromFile = JsonUtil.readJsonFile(INVALID_PERSON_FILE,
                JsonSerializableMedLogger.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicatePersons_throwsIllegalValueException() throws Exception {
        JsonSerializableMedLogger dataFromFile = JsonUtil.readJsonFile(DUPLICATE_PERSON_FILE,
                JsonSerializableMedLogger.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableMedLogger.MESSAGE_DUPLICATE_PERSON,
                dataFromFile::toModelType);
    }

}
