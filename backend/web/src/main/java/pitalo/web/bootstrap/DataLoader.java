package pitalo.web.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pitalo.domain.Address;
import pitalo.domain.Patient.*;
import pitalo.domain.Sex;
import pitalo.domain.Staff.Doctor;
import pitalo.domain.Staff.Nurse;
import pitalo.domain.Staff.Specialty;
import pitalo.persistence.Services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private EmergencyContactService emergencyContactService;

    @Autowired
    private NurseService nurseService;


    @Override
    public void run(String... args) throws Exception {
        loadData();
        System.out.println("Loaded Data...");
    }

    private void loadData() {

        loadPatients();
        loadDoctors();
        loadNurses();
    }

    private void loadNurses() {

        Nurse selma = Nurse
            .builder()
            .firstName("Selma")
            .middleName("H.")
            .lastName("Devito")
            .email("selma@pitalo.com")
            .phoneNumber("(613)-126-3628")
            .sex(Sex.Female)
            .build();

        Nurse rickey = Nurse
            .builder()
            .firstName("Rickey")
            .middleName("A.")
            .lastName("Cavender")
            .email("rickey@pitalo.com")
            .phoneNumber("(613)-421-3458")
            .sex(Sex.Male)
            .build();

        Nurse alex = Nurse
            .builder()
            .firstName("Alexia")
            .lastName("Pigman")
            .email("alexia@pitalo.com")
            .phoneNumber("(613)-653-8204")
            .sex(Sex.Female)
            .build();

        nurseService.save(selma);
        nurseService.save(rickey);
        nurseService.save(alex);
    }


    public void loadPatients() {

        /**
         * Medical History Details
         *
         */

        MedicalHistory history1 = MedicalHistory
            .builder()
            .allergy("Peanuts")
            .allergy("Fish")
            .bloodType(BloodType.ABNEGATIVE)
            .build();

        MedicalHistory history2 = MedicalHistory
            .builder()
            .lifeStyle("Smoking")
            .lifeStyle("Alcohol")
            .bloodType(BloodType.ABPOSITIVE)
            .build();

        MedicalHistory history3 = MedicalHistory
            .builder()
            .lifeStyle("Smoking")
            .lifeStyle("Alcohol")
            .illness("Rheumatoid Arthritis")
            .injury("Knee injury")
            .medication("Celebrex")
            .bloodType(BloodType.ANEGATIVE)
            .build();

        MedicalHistory history4 = MedicalHistory
            .builder()
            .allergy("Penicillin")
            .injury("Groin pull")
            .bloodType(BloodType.ONEGATIVE)
            .build();

        MedicalHistory history5 = MedicalHistory
            .builder()
            .illness("Asthma")
            .surgery("Appendectomy")
            .bloodType(BloodType.OPOSITIVE)
            .build();

        MedicalHistory history6 = MedicalHistory
            .builder()
            .allergy("Milk")
            .illness("Breast Cancer")
            .surgery("Mastectomy")
            .surgery("Hysterectomy")
            .bloodType(BloodType.OPOSITIVE)
            .build();

        MedicalHistory history7 = MedicalHistory
            .builder()
            .illness("Hepatitis B")
            .medication("Engirix-B")
            .bloodType(BloodType.BPOSITIVE)
            .build();

        MedicalHistory history8 = MedicalHistory
            .builder()
            .illness("Diabetes Type I")
            .surgery("Gastric Bypass Surgery")
            .surgery("Bariatric  Surgery")
            .medication("Apidra")
            .medication("Humalog")
            .bloodType(BloodType.BNEGATIVE)
            .build();

        MedicalHistory history9 = MedicalHistory
            .builder()
            .illness("Dyspareunia")
            .medication("Ospemifene")
            .lifeStyle("Smoking")
            .lifeStyle("Alcohol")
            .bloodType(BloodType.OPOSITIVE)
            .build();

        MedicalHistory historyx = MedicalHistory
            .builder()
            .illness("Hypertension")
            .medication("Zestril")
            .bloodType(BloodType.ANEGATIVE)
            .build();



        /**
         * Insurance Details
         *
         */

        Insurance insuritas1 = Insurance
            .builder()
            .groupNumber("0001")
            .policyNumber("0002-234")
            .provider("Insuritas")
            .expiryDate(LocalDate.now())
            .build();

        Insurance insuritas2 = Insurance
            .builder()
            .groupNumber("0001")
            .policyNumber("0234-819")
            .provider("Insuritas")
            .expiryDate(LocalDate.now())
            .build();

        Insurance insuritas3 = Insurance
            .builder()
            .groupNumber("0001")
            .policyNumber("0892-891")
            .provider("Insuritas")
            .expiryDate(LocalDate.now())
            .build();

        Insurance lifeCrest1 = Insurance
            .builder()
            .groupNumber("0002")
            .policyNumber("9079-234")
            .provider("Life Crest")
            .expiryDate(LocalDate.now())
            .build();

        Insurance lifeCrest2 = Insurance
            .builder()
            .groupNumber("0002")
            .policyNumber("7628-123")
            .provider("Life Crest")
            .expiryDate(LocalDate.now())
            .build();

        Insurance lifeCrest3 = Insurance
            .builder()
            .groupNumber("0002")
            .policyNumber("8698-097")
            .provider("Life Crest")
            .expiryDate(LocalDate.now())
            .build();

        Insurance paySurance1 = Insurance
            .builder()
            .groupNumber("0003")
            .policyNumber("8208-343")
            .provider("Pay Surance")
            .expiryDate(LocalDate.now())
            .build();

        Insurance paySurance2 = Insurance
            .builder()
            .groupNumber("0003")
            .policyNumber("9876-978")
            .provider("Pay Surance")
            .expiryDate(LocalDate.now())
            .build();

        Insurance paySurance3 = Insurance
            .builder()
            .groupNumber("0003")
            .policyNumber("3424-986")
            .provider("Pay Surance")
            .expiryDate(LocalDate.now())
            .build();

        Insurance fundGuard = Insurance
            .builder()
            .groupNumber("0004")
            .policyNumber("7862-232")
            .provider("Fund Guard")
            .expiryDate(LocalDate.now())
            .build();


        /**
         * Address Data
         *
         */

        Address address1 = Address
            .builder()
            .addressLine1("397 S. Harvey Dr.")
            .city("Meaford")
            .province("ON")
            .postalCode("N4L 2S5")
            .build();

        Address address2 = Address
            .builder()
            .addressLine1("17 Bay Meadows Ave.")
            .city("Sainte-Adèle")
            .province("QC")
            .postalCode("J8B 0M2")
            .build();

        Address address3 = Address
            .builder()
            .addressLine1("755 W. Smith Ave.")
            .city("Laterrière")
            .province("QC")
            .postalCode("G7N 8H2")
            .build();

        Address address4 = Address
            .builder()
            .addressLine1("73 Carriage Lane")
            .city("Portage la Prairie")
            .province("MB")
            .postalCode("R1N 1T5")
            .build();

        Address address5 = Address
            .builder()
            .addressLine1("32 Lilac Lane")
            .city("Beaumont")
            .province("AB")
            .postalCode("T4X 5R0")
            .build();

        Address address6 = Address
            .builder()
            .addressLine1("192 Tunnel Rd.")
            .city("Georgetown")
            .province("ON")
            .postalCode("L7G 5S7")
            .build();

        Address address7 = Address
            .builder()
            .addressLine1("9197 Trout Rd.")
            .city("Belledune")
            .province("NB")
            .postalCode("E8G 4C5")
            .build();

        Address address8 = Address
            .builder()
            .addressLine1("199 Tallwood Lane")
            .city("Baie-Saint-Paul")
            .province("QC")
            .postalCode("G3Z 5K5")
            .build();

        Address address9 = Address
            .builder()
            .addressLine1("7198 West Ivy Circle")
            .city("Brooks")
            .province("AB")
            .postalCode("T1R 6H4")
            .build();

        Address addressx = Address
            .builder()
            .addressLine1("208 Elizabeth Drive")
            .city("Dryden")
            .province("ON")
            .postalCode("P8N 7G5")
            .build();



        /**
         *  Patient Details
         *
         */

        Patient patient1 = Patient
            .builder()
            .firstName("John")
            .middleName("R.")
            .lastName("Krauss")
            .healthNumber("4356-937-271-DS")
            .occupation("Farmer")
            .insurance(insuritas1)
            .email("JKrauss@gmail.com")
            .address(address1)
            .medicalHistory(history1)
            .phoneNumber("(613)-890-9876")
            .sex(Sex.Male)
            .build();

        Patient patient2 = Patient
            .builder()
            .firstName("Maura")
            .middleName("W.")
            .lastName("Gales")
            .healthNumber("2293-327-331-DS")
            .occupation("Baker")
            .insurance(insuritas2)
            .email("MauraG@sweets.com")
            .address(address2)
            .phoneNumber("(613)-836-8374")
            .medicalHistory(history6)
            .sex(Sex.Female)
            .build();

        Patient patient3 = Patient
            .builder()
            .firstName("Verla")
            .lastName("Sullins")
            .healthNumber("2085-839-301-DS")
            .occupation("Cook")
            .insurance(insuritas3)
            .address(address3)
            .phoneNumber("(613)-223-4623")
            .medicalHistory(history8)
            .sex(Sex.Female)
            .build();

        Patient patient4 = Patient
            .builder()
            .firstName("Noel")
            .middleName("N.")
            .lastName("Hufford")
            .healthNumber("3871-030-311-DS")
            .occupation("Policeman")
            .email("jarUnicorn@gmail.com")
            .insurance(lifeCrest1)
            .address(address4)
            .phoneNumber("(613)-986-1342")
            .medicalHistory(history2)
            .sex(Sex.Male)
            .build();

        Patient patient5 = Patient
            .builder()
            .firstName("Jon")
            .lastName("Killiam")
            .healthNumber("3759-417-791-DS")
            .occupation("Teacher")
            .insurance(lifeCrest2)
            .email("jonkilliam@gmail.com")
            .address(address5)
            .phoneNumber("(613)-892-7348")
            .medicalHistory(history4)
            .sex(Sex.Male)
            .build();

        Patient patient6 = Patient
            .builder()
            .firstName("Emilio")
            .middleName("K.")
            .lastName("Waynick")
            .healthNumber("6986-964-171-DS")
            .occupation("Bus Driver")
            .insurance(lifeCrest3)
            .email("emilioway@yahoo.com")
            .address(address6)
            .phoneNumber("(613)-753-9864")
            .medicalHistory(history5)
            .sex(Sex.Male)
            .build();

        Patient patient7 = Patient
            .builder()
            .firstName("Nelson")
            .lastName("Cornman")
            .healthNumber("4169-753-031-DS")
            .occupation("Accountant")
            .insurance(paySurance1)
            .email("nman@yahoo.com")
            .address(address7)
            .phoneNumber("(613)-453-8763")
            .medicalHistory(historyx)
            .sex(Sex.Male)
            .build();

        Patient patient8 = Patient
            .builder()
            .firstName("Breanna")
            .middleName("M.")
            .lastName("Brownlow")
            .healthNumber("5322-541-641-DS")
            .occupation("Cleaner")
            .insurance(paySurance2)
            .email("blow@gmail.com")
            .address(address8)
            .phoneNumber("(613)-872-8963")
            .medicalHistory(history3)
            .sex(Sex.Female)
            .build();

        Patient patient9 = Patient
            .builder()
            .firstName("Libby")
            .middleName("T.")
            .lastName("Marmo")
            .healthNumber("3464-888-921-DS")
            .occupation("Florist")
            .insurance(paySurance3)
            .address(address9)
            .phoneNumber("(613)-324-8962")
            .medicalHistory(history7)
            .sex(Sex.Female)
            .build();

        Patient patientX = Patient
            .builder()
            .firstName("Kate")
            .lastName("Upward")
            .healthNumber("2126-453-031-DS")
            .occupation("Lab Assistant")
            .insurance(fundGuard)
            .email("katedown@kxlabs.com")
            .address(addressx)
            .phoneNumber("(613)-478-9286")
            .medicalHistory(history9)
            .sex(Sex.Female)
            .build();



        patientService.save(patient1);
        patientService.save(patient2);
        patientService.save(patient3);
        patientService.save(patient4);
        patientService.save(patient5);
        patientService.save(patient6);
        patientService.save(patient7);
        patientService.save(patient8);
        patientService.save(patient9);
        patientService.save(patientX);

        /**
         *  Emergency Contact Details
         *
         */

        EmergencyContact pat1 = EmergencyContact
            .builder()
            .firstName("Paul")
            .lastName("Krauss")
            .relationship("Brother")
            .phoneNumber("(613)-923-9274")
            .patient(patient1)
            .build();

        EmergencyContact pat12 = EmergencyContact
            .builder()
            .firstName("Kara")
            .lastName("Krauss")
            .relationship("Wife")
            .phoneNumber("(613)-923-1243")
            .patient(patient1)
            .build();

        EmergencyContact pat2 = EmergencyContact
            .builder()
            .firstName("Drew")
            .lastName("Gales")
            .relationship("Husband")
            .phoneNumber("(613)-987-9274")
            .patient(patient2)
            .build();

        EmergencyContact pat3 = EmergencyContact
            .builder()
            .firstName("Carlos")
            .lastName("Sanchez")
            .relationship("Friend")
            .phoneNumber("(613)-841-3294")
            .patient(patient3)
            .build();

        EmergencyContact pat31 = EmergencyContact
            .builder()
            .firstName("Mona")
            .lastName("Vinci")
            .relationship("Friend")
            .phoneNumber("(613)-486-2631")
            .patient(patient3)
            .build();

        EmergencyContact pat4 = EmergencyContact
            .builder()
            .firstName("Rachel")
            .lastName("Hufford")
            .relationship("Wife")
            .phoneNumber("(613)-142-2631")
            .patient(patient4)
            .build();

        EmergencyContact pat5 = EmergencyContact
            .builder()
            .firstName("Lavonne")
            .lastName("Delia")
            .relationship("Friend")
            .phoneNumber("(613)-229-2631")
            .patient(patient5)
            .build();

        EmergencyContact pat6 = EmergencyContact
            .builder()
            .firstName("Sofia")
            .lastName("Waynick")
            .relationship("Wife")
            .phoneNumber("(613)-324-6363")
            .patient(patient6)
            .build();

        EmergencyContact pat61 = EmergencyContact
            .builder()
            .firstName("Clara")
            .lastName("Waynick")
            .relationship("Sister")
            .phoneNumber("(613)-845-7161")
            .patient(patient6)
            .build();

        EmergencyContact pat7 = EmergencyContact
            .builder()
            .firstName("Avery")
            .lastName("Phong")
            .relationship("Friend")
            .phoneNumber("(613)-856-6363")
            .patient(patient7)
            .build();

        EmergencyContact pat8 = EmergencyContact
            .builder()
            .firstName("Marcel")
            .lastName("Brownlow")
            .relationship("Wife")
            .phoneNumber("(613)-324-6363")
            .patient(patient8)
            .build();

        EmergencyContact pat9 = EmergencyContact
            .builder()
            .firstName("Lavon")
            .lastName("Whittemore")
            .relationship("Friend")
            .phoneNumber("(613)-253-2163")
            .patient(patient9)
            .build();

        EmergencyContact pat91 = EmergencyContact
            .builder()
            .firstName("Teressa")
            .lastName("Marmo")
            .relationship("Sister")
            .phoneNumber("(613)-234-2463")
            .patient(patient9)
            .build();

        EmergencyContact patx = EmergencyContact
            .builder()
            .firstName("Klara")
            .lastName("Tinkham")
            .relationship("Friend")
            .phoneNumber("(613)-956-6123")
            .patient(patientX)
            .build();

        emergencyContactService.save(pat1);
        emergencyContactService.save(pat12);
        emergencyContactService.save(pat2);
        emergencyContactService.save(pat3);
        emergencyContactService.save(pat31);
        emergencyContactService.save(pat4);
        emergencyContactService.save(pat5);
        emergencyContactService.save(pat6);
        emergencyContactService.save(pat61);
        emergencyContactService.save(pat7);
        emergencyContactService.save(pat8);
        emergencyContactService.save(pat9);
        emergencyContactService.save(pat91);
        emergencyContactService.save(patx);
    }

    public void loadDoctors() {
        Specialty cardio = Specialty
            .builder()
            .name("Cardiology")
            .build();

        Specialty pedia = Specialty
            .builder()
            .name("Pediatric Immunologist")
            .build();

        Specialty emer = Specialty
            .builder()
            .name("Emergency Medical Specialist")
            .build();

        Specialty gen = Specialty
            .builder()
            .name("General Practitioner")
            .build();

        Specialty gyna = Specialty
            .builder()
            .name("Obstetrician-Gynecologist")
            .build();

        Specialty nephro = Specialty
            .builder()
            .name("Nephrologist")
            .build();

        specialtyService.save(nephro);
        specialtyService.save(cardio);
        specialtyService.save(pedia);
        specialtyService.save(emer);
        specialtyService.save(gen);
        specialtyService.save(gyna);

        Doctor charise = Doctor
            .builder()
            .firstName("Charise")
            .middleName("T.")
            .lastName("Broome")
            .email("chbroome@pitalo.com")
            .specialty(cardio)
            .phoneNumber("(613)-754-7285")
            .sex(Sex.Female)
            .build();

        Doctor elvina = Doctor
            .builder()
            .firstName("Elvina")
            .middleName("S.")
            .lastName("Abdul")
            .email("elabdul@pitalo.com")
            .specialty(gyna)
            .phoneNumber("(613)-918-8962")
            .sex(Sex.Female)
            .build();

        Doctor jonah = Doctor
            .builder()
            .firstName("Jonah")
            .middleName("D.")
            .lastName("Swinton")
            .email("joswinton@pitalo.com")
            .specialty(nephro)
            .phoneNumber("(613)-977-0882")
            .sex(Sex.Male)
            .build();

        Doctor tami = Doctor
            .builder()
            .firstName("Tamika")
            .lastName("Akerley")
            .email("takerley@pitalo.com")
            .specialty(gen)
            .phoneNumber("(613)-232-2322")
            .sex(Sex.Female)
            .build();

        Doctor garrett = Doctor
            .builder()
            .firstName("Garrett")
            .middleName("P.")
            .lastName("Deleon")
            .email("gdeleon@pitalo.com")
            .specialty(emer)
            .phoneNumber("(613)-764-4548")
            .sex(Sex.Male)
            .build();

        Doctor ellen = Doctor
            .builder()
            .firstName("Ellen")
            .middleName("G.")
            .lastName("Behler")
            .email("ellbehler@pitalo.com")
            .specialty(emer)
            .phoneNumber("(613)-968-9567")
            .sex(Sex.Female)
            .build();

        Doctor sara = Doctor
            .builder()
            .firstName("Sara")
            .lastName("Lavoie")
            .email("slavoie@pitalo.com")
            .specialty(pedia)
            .phoneNumber("(613)-225-3628")
            .sex(Sex.Female)
            .build();

        doctorService.save(charise);
        doctorService.save(sara);
        doctorService.save(ellen);
        doctorService.save(garrett);
        doctorService.save(tami);
        doctorService.save(jonah);
        doctorService.save(elvina);

    }
}
