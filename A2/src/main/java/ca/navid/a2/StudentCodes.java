package ca.navid.a2;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

/**
 * Student codes should be focused here and part of this class is to be completed by students
 * Make sure to modify {@link #mlsLookup(UUID) mlsLookup} as needed.
 */
@Controller
public class StudentCodes {

    //Logger instance to be used if you need to print out any debug messages.
    private static final Logger logger = LoggerFactory.getLogger(StudentCodes.class);

    //our simplified database text file under: resources/data/mls.txt
    @Value("classpath:data/mls.txt")
    Resource mlsFile;

    /**
     * This is a simple method that is acting as a web controller to find the details about MLS record
     * If your codes runs properly you should be able to lookup a record via:
     * <a href="http://localhost:9000/mlslookup?uuid=03b9cbea-a90d-406c-9e5b-623da6e2736d">http://localhost:9000/mlslookup?uuid=</a>
     * If you like to know more about web APIs and have some extra time (not mandatory):
     *
     * @param uuid the UUID of an MLS record that its details needs to be extracted from the mls records
     * @return the corresponding MLS record to the given UUID
     * @see <a href="https://docs.microsoft.com/en-us/azure/architecture/best-practices/api-design">REST Web API Design</a>
     * and <a href="https://spring.io/guides/gs/rest-service/">Building REST Web APIs in Spring Framework</a>.
     */
    @RequestMapping(value = "/mlslookup", method = RequestMethod.GET)
    public @ResponseBody
    /**
     * this method using cache mechanism
     * if cannot find mls in cache memory, then iterate the data file
     * and add the new <key, value> into memory. if cannot find the uuid in file,
     * throws an Exception
     * if can find in memory, return the value of the key
     */
    MultipleListingService mlsLookup(@RequestParam(value = "uuid", required = true) UUID uuid) {
        // make sure cacheMap ia not null
        Singleton s = Singleton.getInstance();
        MultipleListingService record = Singleton.getMls(uuid);
        if (record == null) {
            try (LineIterator it = FileUtils.lineIterator(mlsFile.getFile(), "UTF-8")) {
                // @todo for students: Modify below and add your cache lookup code ... /////////////////
                while (it.hasNext()) {
                    String line = it.nextLine();
                    if (line.startsWith(uuid.toString())) {
                        record = A2Utils.createMLSFromTextRecord(line);
                        logger.debug(record.toString());
                        Singleton.addCache(uuid, record);
                        // to see the lookup method whether into this block
                        //if the number change means yes, new data add in the memory
                        System.out.println(Singleton.getSize() + " new data added into cache");
                        return record;
                    }
                }
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "MLS record not found");
            }
            catch (IOException e) {
                e.printStackTrace();
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "IO exception");
            }
        }
        else{
            System.out.println("Find in cache");
            return record;
        }
    }

}
