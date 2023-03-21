package springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.domain.Author;
import springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.domain.Book;
import springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.domain.Publisher;
import springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.repositories.AuthorRepository;
import springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.repositories.BookRepository;
import springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.repositories.PublisherRepository;

/**
 * @Created 21 03 2023 - 11:38 AM
 * @Author Hazeem Hassan
 */
@Component
public class BootstrapData  implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        saveAndDisplayData();

    }

    private void saveAndDisplayData() {

        //saving data
        /*Publisher*/
        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Sir Syed Publisher");
        publisher1.setPublisherAddress("Gulbery");
        publisher1.setPublisherCity("Lahore");
        publisher1.setPublisherState("Punjab");
        publisher1.setPublisherZipCode("12345");
        Publisher publisher1Saved = publisherRepository.save(publisher1);
        Publisher publisher2 = new Publisher();
        publisher2.setPublisherName("Muhammad Iqbal Publisher");
        publisher2.setPublisherAddress("Gulbery");
        publisher2.setPublisherCity("Lahore");
        publisher2.setPublisherState("Punjab");
        publisher2.setPublisherZipCode("12345");
        Publisher publisher2Saved = publisherRepository.save(publisher2);
        /*Author1*/
        Author sirSyedAhmadKhan = new Author();
        sirSyedAhmadKhan.setFirstName("Sir Syed ");
        sirSyedAhmadKhan.setLastName("Ahmad Khan");

        Author sirSyedAhmadKhanSaved = authorRepository.save(sirSyedAhmadKhan);
        /*Books For author 1*/
        Book tefseerUlQuran = new Book();
        tefseerUlQuran.setTitle("TAFSEER - UL - QURAN");
        tefseerUlQuran.setIsbn("1877-1362");
        tefseerUlQuran.setPublisher(publisher1);

        Book aakiriMazameen = new Book();
        aakiriMazameen.setTitle("AAKHIRI MAZAMEEN");
        aakiriMazameen.setIsbn("1898-187");
        aakiriMazameen.setPublisher(publisher1);

        Book khutbatEAhmadiya = new Book();
        khutbatEAhmadiya.setTitle("KHUTBAT - E - AHMADIYA");
        khutbatEAhmadiya.setIsbn("1870-696");
        khutbatEAhmadiya.setPublisher(publisher1);

        Book khutootESirSyed = new Book();
        khutootESirSyed.setTitle("KHUTOOT - E - SIR SYED");
        khutootESirSyed.setIsbn("1931-67");
        khutootESirSyed.setPublisher(publisher1);

        Book lectur = new Book();
        lectur.setTitle("LECTUR");
        lectur.setIsbn(" 1889-55");
        lectur.setPublisher(publisher1);

        Book tehzeebulAkhlaq = new Book();
        tehzeebulAkhlaq.setTitle("TAHZEEBUL AKHLAQ");
        tehzeebulAkhlaq.setIsbn("1895-629");
        tehzeebulAkhlaq.setPublisher(publisher1);

        tefseerUlQuran.getAuthors().add(sirSyedAhmadKhan);
        aakiriMazameen.getAuthors().add(sirSyedAhmadKhan);
        khutbatEAhmadiya.getAuthors().add(sirSyedAhmadKhan);
        khutootESirSyed.getAuthors().add(sirSyedAhmadKhan);
        lectur.getAuthors().add(sirSyedAhmadKhan);
        tehzeebulAkhlaq.getAuthors().add(sirSyedAhmadKhan);

        Book tefseerUlQuranSaved = bookRepository.save(tefseerUlQuran);
        Book aakiriMazameenSaved = bookRepository.save(aakiriMazameen);
        Book khutbatEAhmadiyaSaved = bookRepository.save(khutbatEAhmadiya);
        Book khutootESirSyedSaved = bookRepository.save(khutootESirSyed);
        Book lecturSaved = bookRepository.save(lectur);
        Book tehzeebulAkhlaqSaved = bookRepository.save(tehzeebulAkhlaq);

        sirSyedAhmadKhanSaved.getBooks().add(tefseerUlQuranSaved);
        sirSyedAhmadKhanSaved.getBooks().add(aakiriMazameenSaved);
        sirSyedAhmadKhanSaved.getBooks().add(khutbatEAhmadiyaSaved);
        sirSyedAhmadKhanSaved.getBooks().add(khutootESirSyedSaved);
        sirSyedAhmadKhanSaved.getBooks().add(lecturSaved);
        sirSyedAhmadKhanSaved.getBooks().add(tehzeebulAkhlaqSaved);
        /*Author 2 Allama Iqbal */
        Author allamaIqbal = new Author();
        allamaIqbal.setFirstName("Muhammad ");
        allamaIqbal.setLastName("Allama Iqbal");

        Author allamaIqbalSaved = authorRepository.save(allamaIqbal);
        /*Books For author 2*/
        Book bangEDara = new Book();
        bangEDara.setTitle("BANG - E - DARA");
        bangEDara.setIsbn("1924-354");
        bangEDara.setPublisher(publisher2);


        Book balEJibreel = new Book();
        balEJibreel.setTitle("BAL - E - JIBREEL");
        balEJibreel.setIsbn("1935-222");
        balEJibreel.setPublisher(publisher2);

        Book zarbEKaleem = new Book();
        zarbEKaleem.setTitle("ZARB - E - KALEEM");
        zarbEKaleem.setIsbn("1944-194");
        zarbEKaleem.setPublisher(publisher2);

        Book shikwaJawabEShiwkwa = new Book();
        shikwaJawabEShiwkwa.setTitle("SHIKWA JAWAB -E - SHIKWA");
        shikwaJawabEShiwkwa.setIsbn("0913-96");
        shikwaJawabEShiwkwa.setPublisher(publisher2);

        Book asrarEKhudi = new Book();
        asrarEKhudi.setTitle("ASRAR - E - KHUDI");
        asrarEKhudi.setIsbn("1976-87");
        asrarEKhudi.setPublisher(publisher2);

        Book asrorORamooz = new Book();
        asrorORamooz.setTitle("ASRAR - O - RAMOOZ");
        asrorORamooz.setIsbn("1966-203");
        asrorORamooz.setPublisher(publisher2);

        Book khulliyatEIqbal = new Book();
        khulliyatEIqbal.setTitle("KULLIYAT - E - IQBAL");
        khulliyatEIqbal.setIsbn("1953-477");
        khulliyatEIqbal.setPublisher(publisher2);
        // add author to books
        bangEDara.getAuthors().add(allamaIqbal);
        balEJibreel.getAuthors().add(allamaIqbal);
        zarbEKaleem.getAuthors().add(allamaIqbal);
        shikwaJawabEShiwkwa.getAuthors().add(allamaIqbal);
        asrarEKhudi.getAuthors().add(allamaIqbal);
        asrorORamooz.getAuthors().add(allamaIqbal);
        khulliyatEIqbal.getAuthors().add(allamaIqbal);
        // saving data of books in h2 database
        Book bangEDaraSaved = bookRepository.save(bangEDara);
        Book balEJibreelSaved = bookRepository.save(balEJibreel);
        Book zarbEKaleemSaved = bookRepository.save(zarbEKaleem);
        Book shikwaJawabEShiwkwaSaved = bookRepository.save(shikwaJawabEShiwkwa);
        Book asrarEKhudiSaved = bookRepository.save(asrarEKhudi);
        Book asrorORamoozSaved = bookRepository.save(asrorORamooz);
        Book khulliyatEIqbalSaved = bookRepository.save(khulliyatEIqbal);

        // add books to author
        allamaIqbalSaved.getBooks().add(bangEDaraSaved);
        allamaIqbalSaved.getBooks().add(balEJibreelSaved);
        allamaIqbalSaved.getBooks().add(zarbEKaleemSaved);
        allamaIqbalSaved.getBooks().add(shikwaJawabEShiwkwaSaved);
        allamaIqbalSaved.getBooks().add(asrarEKhudiSaved);
        allamaIqbalSaved.getBooks().add(asrorORamoozSaved);
        allamaIqbalSaved.getBooks().add(khulliyatEIqbalSaved);


        //displaying data
        System.out.println("In BootStrap");
        System.out.println("Authors Count : " + authorRepository.count());
        System.out.println("Publisher Count : " + publisherRepository.count());
        System.out.println("Books Count : " + bookRepository.count());
    }

}
