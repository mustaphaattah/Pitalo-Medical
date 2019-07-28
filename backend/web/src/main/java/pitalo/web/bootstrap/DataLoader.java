package pitalo.web.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pitalo.domain.Patient.Insurance;
import pitalo.domain.Patient.Patient;
import pitalo.domain.Sex;
import pitalo.domain.Staff.Doctor;
import pitalo.domain.Staff.Specialty;
import pitalo.persistence.Services.DoctorService;
import pitalo.persistence.Services.PatientService;
import pitalo.persistence.Services.SpecialtyService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private SpecialtyService specialtyService;


    @Override
    public void run(String... args) throws Exception {
        loadData();
        System.out.println("Loaded Data...");
    }

    private void loadData() {

        loadPatients();
        loadDoctors();
    }


    public void loadPatients() {

        /*
            Insurance Details
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
            Patient Data
         */

        Patient patient1 = Patient
            .builder()
            .firstName("John")
            .lastName("Krauss")
            .healthNumber("4356-937-271-DS")
            .occupation("Farmer")
            .insurance(insuritas1)
            .sex(Sex.Male)
            .build();

        Patient patient2 = Patient
            .builder()
            .firstName("Maura")
            .lastName("Gales")
            .healthNumber("2293-327-331-DS")
            .occupation("Baker")
            .insurance(insuritas2)
            .sex(Sex.Female)
            .build();

        Patient patient3 = Patient
            .builder()
            .firstName("Verla")
            .lastName("Sullins")
            .healthNumber("2085-839-301-DS")
            .occupation("Cook")
            .insurance(insuritas3)
            .sex(Sex.Female)
            .build();

        Patient patient4 = Patient
            .builder()
            .firstName("Noel")
            .lastName("Hufford")
            .healthNumber("3871-030-311-DS")
            .occupation("Policeman")
            .insurance(lifeCrest1)
            .sex(Sex.Male)
            .build();

        Patient patient5 = Patient
            .builder()
            .firstName("Jon")
            .lastName("Killiam")
            .healthNumber("3759-417-791-DS")
            .occupation("Teacher")
            .insurance(lifeCrest2)
            .sex(Sex.Male)
            .build();

        Patient patient6 = Patient
            .builder()
            .firstName("Emilio")
            .lastName("Waynick")
            .healthNumber("6986-964-171-DS")
            .occupation("Bus Driver")
            .insurance(lifeCrest3)
            .sex(Sex.Male)
            .build();

        Patient patient7 = Patient
            .builder()
            .firstName("Nelson")
            .lastName("Cornman")
            .healthNumber("4169-753-031-DS")
            .occupation("Driver")
            .insurance(paySurance1)
            .sex(Sex.Male)
            .build();

        Patient patient8 = Patient
            .builder()
            .firstName("Breanna")
            .lastName("Brownlow")
            .healthNumber("5322-541-641-DS")
            .occupation("Cleaner")
            .insurance(paySurance2)
            .sex(Sex.Female)
            .build();

        Patient patient9 = Patient
            .builder()
            .firstName("Libby")
            .lastName("Marmo")
            .healthNumber("3464-888-921-DS")
            .occupation("Florist")
            .insurance(paySurance3)
            .sex(Sex.Female)
            .build();

        Patient patientX = Patient
            .builder()
            .firstName("Kate")
            .lastName("Upward")
            .healthNumber("2126-453-031-DS")
            .occupation("Lab Assistant")
            .insurance(fundGuard)
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
            .lastName("Broome")
            .email("chbroome@pitalo.com")
            .specialty(cardio)
            .sex(Sex.Female)
            .build();

        Doctor elvina = Doctor
            .builder()
            .firstName("Elvina")
            .lastName("Abdul")
            .email("elAbdul@pitalo.com")
            .specialty(gyna)
            .sex(Sex.Female)
            .build();

        Doctor jonah = Doctor
            .builder()
            .firstName("Jonah")
            .lastName("Swinton")
            .email("joSwinton@pitalo.com")
            .specialty(nephro)
            .sex(Sex.Male)
            .build();

        Doctor tami = Doctor
            .builder()
            .firstName("Tamika")
            .lastName("Akerley")
            .email("tAkerley@pitalo.com")
            .specialty(gen)
            .sex(Sex.Female)
            .build();

        Doctor garrett = Doctor
            .builder()
            .firstName("Garrett")
            .lastName("Deleon")
            .email("gDeleon@pitalo.com")
            .specialty(emer)
            .sex(Sex.Male)
            .build();

        Doctor ellen = Doctor
            .builder()
            .firstName("Ellen")
            .lastName("Behler")
            .email("ellBehler@pitalo.com")
            .specialty(emer)
            .sex(Sex.Female)
            .build();

        Doctor sara = Doctor
            .builder()
            .firstName("Sara")
            .lastName("Lavoie")
            .email("SLavoie@pitalo.com")
            .specialty(pedia)
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
