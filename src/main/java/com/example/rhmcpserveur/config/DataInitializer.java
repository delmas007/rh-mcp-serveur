package com.example.rhmcpserveur.config;

import com.example.rhmcpserveur.model.*;
import com.example.rhmcpserveur.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final SkillService skillService;
    private final JobSeekerService jobSeekerService;
    private final EmployeeService employeeService;
    private final ExperienceService experienceService;
    private final EducationService educationService;

    private final Random random = new Random();

    @Override
    public void run(String... args) {
        // Create skills
        List<Skill> programmingSkills = createProgrammingSkills();
        List<Skill> softSkills = createSoftSkills();

        // Create job seekers
        createJobSeekers(programmingSkills, softSkills);

        // Create employees
        createEmployees(programmingSkills, softSkills);
    }

    private List<Skill> createProgrammingSkills() {
        String[] skillNames = {
            "Java", "Spring Boot", "JavaScript", "React", "Angular", "Vue.js", 
            "Python", "Django", "Flask", "Node.js", "Express", "TypeScript",
            "C#", ".NET Core", "PHP", "Laravel", "Symfony", "Ruby", "Ruby on Rails",
            "Go", "Rust", "Kotlin", "Swift", "Objective-C", "C++", "C", "SQL",
            "PostgreSQL", "MySQL", "MongoDB", "Redis", "Elasticsearch", "Docker",
            "Kubernetes", "AWS", "Azure", "GCP", "Git", "CI/CD", "Jenkins",
            "GitHub Actions", "TDD", "BDD", "Microservices", "REST API", "GraphQL"
        };

        String[] levels = {"Beginner", "Intermediate", "Advanced", "Expert"};

        return Arrays.stream(skillNames)
                .map(name -> {
                    String level = levels[random.nextInt(levels.length)];
                    return skillService.getOrCreate(name, level);
                })
                .toList();
    }

    private List<Skill> createSoftSkills() {
        String[] skillNames = {
            "Communication", "Teamwork", "Problem Solving", "Time Management",
            "Adaptability", "Leadership", "Creativity", "Critical Thinking",
            "Emotional Intelligence", "Conflict Resolution", "Negotiation",
            "Presentation Skills", "Project Management", "Agile Methodologies",
            "Scrum", "Kanban", "Customer Service", "Mentoring"
        };

        String[] levels = {"Beginner", "Intermediate", "Advanced", "Expert"};

        return Arrays.stream(skillNames)
                .map(name -> {
                    String level = levels[random.nextInt(levels.length)];
                    return skillService.getOrCreate(name, level);
                })
                .toList();
    }

    private void createJobSeekers(List<Skill> programmingSkills, List<Skill> softSkills) {
        String[] firstNames = {"Jean", "Marie", "Pierre", "Sophie", "Thomas", "Camille", "Lucas", "Emma", "Hugo", "Léa"};
        String[] lastNames = {"Martin", "Bernard", "Dubois", "Thomas", "Robert", "Richard", "Petit", "Durand", "Leroy", "Moreau"};
        String[] jobTitles = {"Full Stack Developer", "Frontend Developer", "Backend Developer", "DevOps Engineer", "Data Scientist", "Mobile Developer", "QA Engineer", "Software Architect"};
        String[] locations = {"Paris", "Lyon", "Marseille", "Bordeaux", "Lille", "Toulouse", "Nantes", "Strasbourg"};
        String[] workTypes = {"Remote", "Hybrid", "On-site"};

        for (int i = 0; i < 10; i++) {
            JobSeeker jobSeeker = JobSeeker.builder()
                    .firstName(firstNames[random.nextInt(firstNames.length)])
                    .lastName(lastNames[random.nextInt(lastNames.length)])
                    .email(generateEmail(firstNames[random.nextInt(firstNames.length)], lastNames[random.nextInt(lastNames.length)]))
                    .phoneNumber(generatePhoneNumber())
                    .address(generateAddress(locations[random.nextInt(locations.length)]))
                    .availableFrom(LocalDate.now().plusDays(random.nextInt(30)))
                    .preferredJobTitle(jobTitles[random.nextInt(jobTitles.length)])
                    .preferredWorkLocation(locations[random.nextInt(locations.length)])
                    .preferredWorkType(workTypes[random.nextInt(workTypes.length)])
                    .resumeSummary(generateResumeSummary())
                    .activelyLooking(random.nextBoolean())
                    .build();

            // Add random skills
            addRandomSkills(jobSeeker, programmingSkills, 3, 7);
            addRandomSkills(jobSeeker, softSkills, 2, 5);

            JobSeeker savedJobSeeker = jobSeekerService.save(jobSeeker);

            // Add experiences
            addExperiences(savedJobSeeker, 1, 3);

            // Add education
            addEducation(savedJobSeeker, 1, 2);
        }
    }

    private void createEmployees(List<Skill> programmingSkills, List<Skill> softSkills) {
        String[] firstNames = {"Alexandre", "Julie", "Nicolas", "Aurélie", "David", "Céline", "Julien", "Elodie", "Mathieu", "Sandrine"};
        String[] lastNames = {"Lefebvre", "Roux", "Fournier", "Girard", "Bonnet", "Dupont", "Lambert", "Fontaine", "Rousseau", "Vincent"};
        String[] departments = {"Engineering", "R&D", "Product", "QA", "DevOps", "Mobile", "Frontend", "Backend"};
        String[] positions = {"Senior Developer", "Lead Developer", "Software Engineer", "Tech Lead", "Principal Engineer", "Software Architect"};
        String[] projects = {"E-commerce Platform", "Banking App", "Healthcare System", "Logistics Management", "CRM System", "Social Media App", "Booking System", "Payment Gateway"};

        for (int i = 0; i < 10; i++) {
            Employee.AvailabilityStatus status = Employee.AvailabilityStatus.values()[random.nextInt(Employee.AvailabilityStatus.values().length)];
            String currentProject = status == Employee.AvailabilityStatus.ON_MISSION ? projects[random.nextInt(projects.length)] : null;

            Employee employee = Employee.builder()
                    .firstName(firstNames[random.nextInt(firstNames.length)])
                    .lastName(lastNames[random.nextInt(lastNames.length)])
                    .email(generateEmail(firstNames[random.nextInt(firstNames.length)], lastNames[random.nextInt(lastNames.length)]))
                    .phoneNumber(generatePhoneNumber())
                    .address(generateAddress("Paris"))
                    .employeeId("EMP" + (1000 + i))
                    .hireDate(LocalDate.now().minusMonths(random.nextInt(60)))
                    .department(departments[random.nextInt(departments.length)])
                    .position(positions[random.nextInt(positions.length)])
                    .availabilityStatus(status)
                    .availableFrom(status != Employee.AvailabilityStatus.AVAILABLE ? LocalDate.now().plusDays(random.nextInt(90) + 10) : null)
                    .currentProject(currentProject)
                    .currentProjectDescription(currentProject != null ? "Working on " + currentProject + " project" : null)
                    .build();

            // Add random skills
            addRandomSkills(employee, programmingSkills, 4, 8);
            addRandomSkills(employee, softSkills, 3, 6);

            Employee savedEmployee = employeeService.save(employee);

            // Add experiences
            addExperiences(savedEmployee, 2, 4);

            // Add education
            addEducation(savedEmployee, 1, 3);
        }
    }

    private void addRandomSkills(Person person, List<Skill> skills, int min, int max) {
        int numSkills = random.nextInt(max - min + 1) + min;
        // Initialize skills collection if it's null
        if (person.getSkills() == null) {
            person.setSkills(new HashSet<>());
        }
        for (int i = 0; i < numSkills; i++) {
            Skill skill = skills.get(random.nextInt(skills.size()));
            if (!person.getSkills().contains(skill)) {
                person.getSkills().add(skill);
            }
        }
    }

    private void addExperiences(Person person, int min, int max) {
        String[] companies = {"Google", "Microsoft", "Amazon", "Apple", "Facebook", "Netflix", "Uber", "Airbnb", "Twitter", "LinkedIn", "Oracle", "IBM", "Intel", "Samsung", "Sony"};
        String[] positions = {"Software Engineer", "Senior Developer", "Tech Lead", "Software Architect", "Full Stack Developer", "Frontend Developer", "Backend Developer", "DevOps Engineer"};

        int numExperiences = random.nextInt(max - min + 1) + min;
        LocalDate endDate = LocalDate.now();

        for (int i = 0; i < numExperiences; i++) {
            boolean currentlyWorking = i == 0 && random.nextBoolean();
            LocalDate startDate = endDate.minusMonths(random.nextInt(24) + 6);

            Experience experience = new Experience();
            experience.setPerson(person);
            experience.setCompanyName(companies[random.nextInt(companies.length)]);
            experience.setPosition(positions[random.nextInt(positions.length)]);
            experience.setDescription("Worked on various projects using " + String.join(", ", getRandomTechnologies(3)));
            experience.setStartDate(startDate);
            experience.setEndDate(currentlyWorking ? null : endDate);
            experience.setCurrentlyWorking(currentlyWorking);

            experienceService.save(experience);

            endDate = startDate.minusDays(random.nextInt(30) + 1);
        }
    }

    private void addEducation(Person person, int min, int max) {
        String[] institutions = {"University of Paris", "Sorbonne University", "École Polytechnique", "CentraleSupélec", "INSA Lyon", "Télécom Paris", "ENSAE Paris", "HEC Paris", "ESSEC Business School", "EDHEC Business School"};
        String[] degrees = {"Bachelor's", "Master's", "Ph.D.", "MBA", "Engineering Degree"};
        String[] fields = {"Computer Science", "Software Engineering", "Data Science", "Artificial Intelligence", "Information Systems", "Cybersecurity", "Business Informatics"};

        int numEducations = random.nextInt(max - min + 1) + min;
        LocalDate endDate = LocalDate.now().minusYears(random.nextInt(3));

        for (int i = 0; i < numEducations; i++) {
            boolean currentlyStudying = i == 0 && random.nextBoolean() && person instanceof JobSeeker;
            LocalDate startDate = endDate.minusYears(random.nextInt(3) + 1);

            Education education = new Education();
            education.setPerson(person);
            education.setInstitution(institutions[random.nextInt(institutions.length)]);
            education.setDegree(degrees[random.nextInt(degrees.length)]);
            education.setFieldOfStudy(fields[random.nextInt(fields.length)]);
            education.setStartDate(startDate);
            education.setEndDate(currentlyStudying ? null : endDate);
            education.setCurrentlyStudying(currentlyStudying);
            education.setDescription("Studied " + education.getFieldOfStudy() + " with focus on software development and algorithms");

            educationService.save(education);

            endDate = startDate.minusDays(random.nextInt(60) + 30);
        }
    }

    private String generateEmail(String firstName, String lastName) {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "protonmail.com", "aol.com", "icloud.com"};
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + domains[random.nextInt(domains.length)];
    }

    private String generatePhoneNumber() {
        return "0" + (random.nextInt(5) + 6) + String.format("%08d", random.nextInt(100000000));
    }

    private String generateAddress(String city) {
        int streetNumber = random.nextInt(100) + 1;
        String[] streetNames = {"Rue de la Paix", "Avenue des Champs-Élysées", "Boulevard Saint-Michel", "Rue de Rivoli", "Avenue Montaigne", "Rue du Faubourg Saint-Honoré"};
        String[] postalCodes = {"75001", "75002", "75003", "75004", "75005", "75006", "75007", "75008", "75009", "75010"};

        return streetNumber + " " + streetNames[random.nextInt(streetNames.length)] + ", " + postalCodes[random.nextInt(postalCodes.length)] + " " + city;
    }

    private String generateResumeSummary() {
        String[] summaries = {
            "Développeur expérimenté avec une passion pour la création d'applications efficaces et évolutives.",
            "Programmeur méticuleux avec de solides compétences en résolution de problèmes et un accent sur le code propre.",
            "Ingénieur logiciel innovant avec une expertise dans la construction d'applications web robustes.",
            "Développeur full-stack avec un historique de livraison de solutions logicielles de haute qualité.",
            "Programmeur dévoué avec une expérience des méthodologies de développement agile.",
            "Passionné de technologie avec une solide base en principes d'informatique.",
            "Développeur axé sur les résultats avec d'excellentes compétences en communication et collaboration.",
            "Programmeur adaptable avec une expérience dans diverses piles technologiques et environnements."
        };

        return summaries[random.nextInt(summaries.length)];
    }

    private String[] getRandomTechnologies(int count) {
        String[] technologies = {"Java", "Spring", "JavaScript", "React", "Angular", "Node.js", "Python", "Django", "Flask", "PHP", "Laravel", "Ruby", "Rails", "C#", ".NET", "SQL", "MongoDB", "Redis", "Docker", "Kubernetes", "AWS", "Azure", "GCP"};
        String[] result = new String[count];

        for (int i = 0; i < count; i++) {
            result[i] = technologies[random.nextInt(technologies.length)];
        }

        return result;
    }
}
