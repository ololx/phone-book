package phones.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phones.entities.Book;
import phones.service.BookDaoImpl;
import phones.service.PhoneBookService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@Api(value = "Phone Book", description = "Phone Book Controller")
@RequestMapping(value = "Phone Book")
public class PhoneBook {
    
    public PhoneBook() throws IOException {
    }
    
    @CrossOrigin()
    @RequestMapping(value = "/addPnoneBookRecord", method = RequestMethod.POST, produces = "application/data")
    @ApiOperation(value = "Create new record on Phone Book")
    public ResponseEntity<String> addPnoneBookRecord(
            @ApiParam(value = "Family, Name and Second name")
            @RequestParam(value = "fio", required = false) String fio,
            @ApiParam(value = "Phone number (in format = XXXXXXXXXXX)")
            @RequestParam(value = "phone", required = false) String phone
            ) throws Exception {

        if(fio == null || phone == null) {
            return  new ResponseEntity<String>("Booth fio & phone couldn't be empty", HttpStatus.BAD_REQUEST);
        }

        PhoneBookService mPhoneBookManage = new PhoneBookService();

        return new ResponseEntity<String>(mPhoneBookManage.createRecord(fio, phone).toString(), HttpStatus.OK);
    }

    @CrossOrigin()
    @RequestMapping(value = "/updatePnoneBookRecord", method = RequestMethod.PATCH, produces = "application/data")
    @ApiOperation(value = "Change record on Phone Book")
    public ResponseEntity<String> updatePnoneBookRecord(
            @ApiParam(value = "Book record identificator")
            @RequestParam(value = "id", required = false) Integer id,
            @ApiParam(value = "Family, Name and Second name")
            @RequestParam(value = "fio", required = false) String fio,
            @ApiParam(value = "Phone number (in format = XXXXXXXXXXX)")
            @RequestParam(value = "phone", required = false) String phone
    ) throws Exception {

        if((id == null)) {
            return  new ResponseEntity<String>("Book id couldn't be empty", HttpStatus.BAD_REQUEST);
        } else if(fio == null && phone == null) {
            return  new ResponseEntity<String>("Booth fio & phone couldn't be empty", HttpStatus.BAD_REQUEST);
        }

        PhoneBookService mPhoneBookManage = new PhoneBookService();

        String mResponse;

        try {
            mResponse = mPhoneBookManage.updateRecord(id, fio, phone).toString();
        } catch(SQLException exception) {
            return new ResponseEntity<String>(String.format("SQL: %1$s - %2$s",
                    exception.getErrorCode(),
                    exception.getSQLState()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>(mResponse, HttpStatus.OK);
    }

    @CrossOrigin()
    @RequestMapping(value = "/deletePnoneBookRecord", method = RequestMethod.DELETE, produces = "application/data")
    @ApiOperation(value = "Drop record on Phone Book")
    public ResponseEntity<String> updatePnoneBookRecord(
            @ApiParam(value = "Book record identificator")
            @RequestParam(value = "id", required = false) Integer id
    ) throws Exception {

        if((id == null)) {
            return  new ResponseEntity<String>("Book id couldn't be empty", HttpStatus.BAD_REQUEST);
        }

        PhoneBookService mPhoneBookManage = new PhoneBookService();

        String mResponse;

        try {
            mResponse = mPhoneBookManage.deleteRecord(id).toString();
        } catch(SQLException exception) {
            return new ResponseEntity<String>(String.format("SQL: %1$s - %2$s",
                    exception.getErrorCode(),
                    exception.getSQLState()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>(mResponse, HttpStatus.OK);
    }

    @CrossOrigin()
    @RequestMapping(value = "/getPnoneBookRecords", method = RequestMethod.GET, produces = "application/data")
    @ApiOperation(value = "Recieve all records on Phone Book")
    public ResponseEntity<String> getPnoneBookRecords(
    ) throws Exception {

        PhoneBookService mPhoneBookManage = new PhoneBookService();

        String mResponse;

        try {
            mResponse = mPhoneBookManage.getAllRecords().toString();
        } catch(SQLException exception) {
            return new ResponseEntity<String>(String.format("SQL: %1$s - %2$s",
                    exception.getErrorCode(),
                    exception.getSQLState()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>(mResponse, HttpStatus.OK);
    }

    @CrossOrigin()
    @RequestMapping(value = "/getPnoneBookRecordByFio", method = RequestMethod.GET, produces = "application/data")
    @ApiOperation(value = "Recieve all records on Phone Book with current FIO")
    public ResponseEntity<String> getPnoneBookRecords(
            @ApiParam(value = "Family, Name and Second name")
            @RequestParam(value = "fio", required = false) String fio
    ) throws Exception {

        if(fio.equals("") || fio.isEmpty()) {
            return  new ResponseEntity<String>("fio couldn't be empty", HttpStatus.BAD_REQUEST);
        }

        PhoneBookService mPhoneBookManage = new PhoneBookService();

        String mResponse;

        try {
            mResponse = mPhoneBookManage.getFioRecords(fio).toString();
        } catch(SQLException exception) {
            return new ResponseEntity<String>(String.format("SQL: %1$s - %2$s",
                    exception.getErrorCode(),
                    exception.getSQLState()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>(mResponse, HttpStatus.OK);
    }

    @CrossOrigin()
    @RequestMapping(value = "/getPnoneBookRecordByPhone", method = RequestMethod.GET, produces = "application/data")
    @ApiOperation(value = "Recieve all records on Phone Book with current phone number")
    public ResponseEntity<String> getPnoneBookRecordByPhone(
            @ApiParam(value = "Phone number")
            @RequestParam(value = "phone", required = false) String phone
    ) throws Exception {

        if(phone.equals("") || phone.isEmpty()) {
            return  new ResponseEntity<String>("phone couldn't be empty", HttpStatus.BAD_REQUEST);
        }

        PhoneBookService mPhoneBookManage = new PhoneBookService();

        String mResponse;

        try {
            mResponse = mPhoneBookManage.getPhoneRecords(phone).toString();
        } catch(SQLException exception) {
            return new ResponseEntity<String>(String.format("SQL: %1$s - %2$s",
                    exception.getErrorCode(),
                    exception.getSQLState()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>(mResponse, HttpStatus.OK);
    }
}



