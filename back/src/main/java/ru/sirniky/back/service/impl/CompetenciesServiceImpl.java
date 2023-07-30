    package ru.sirniky.back.service.impl;

    import jakarta.validation.Valid;
    import jakarta.validation.constraints.Min;
    import jakarta.validation.constraints.NotNull;
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;
    import org.springframework.validation.annotation.Validated;
    import ru.sirniky.back.dto.request.CreateCompetenciesRequest;
    import ru.sirniky.back.dto.response.CompetenciesResponse;
    import ru.sirniky.back.entity.Competencies;
    import ru.sirniky.back.exeption.NotFoundException;
    import ru.sirniky.back.mapper.CompetenciesMapper;
    import ru.sirniky.back.repositrory.CompetenciesRepository;
    import ru.sirniky.back.repositrory.EducationalProgramRepository;
    import ru.sirniky.back.service.CompetenciesService;

    import java.util.List;

    @Service
    @RequiredArgsConstructor
    @Validated
    public class CompetenciesServiceImpl implements CompetenciesService {
        public static final String COMPETENCIES_NOT_FOUND_WITH_ID = "Competencies not found with ID: ";
        public static final String NOT_FOUND_EDUCATIONAL_PROGRAMS_WITH_ID = "Not found educationalPrograms with id";

        private final CompetenciesRepository competenciesRepository;
        private final CompetenciesMapper competenciesMapper;
        private final EducationalProgramRepository educationalProgramRepository;

        @Override
        public List<CompetenciesResponse> getAllCompetencies() {
            List<Competencies> competenciesList = competenciesRepository.findAll();
            return competenciesList.stream()
                    .map(competenciesMapper::toDto)
                    .toList();
        }

        @Override
        public CompetenciesResponse getCompetenciesById(@Min(1) @NotNull Long id) {
            var competencies = competenciesRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException(COMPETENCIES_NOT_FOUND_WITH_ID + id));

            return competenciesMapper.toDto(competencies);
        }

        @Override
        @Transactional
        public CompetenciesResponse saveCompetencies(@Valid CreateCompetenciesRequest competenciesRequest) {
            return getCompetenciesResponse(competenciesRequest);
        }

        private CompetenciesResponse getCompetenciesResponse( CreateCompetenciesRequest competenciesRequest) {
            var findingIds = educationalProgramRepository.findAllById(competenciesRequest.educationalProgramIds());
            if (findingIds.size() != competenciesRequest.educationalProgramIds().size()) {
                throw new NotFoundException(NOT_FOUND_EDUCATIONAL_PROGRAMS_WITH_ID);
            }
            var competencies = competenciesMapper.toCompetencies(competenciesRequest);
            competencies.setEducationalPrograms(findingIds);
            competencies = competenciesRepository.save(competencies);

            return competenciesMapper.toDto(competencies);
        }


        @Override
        @Transactional
        public CompetenciesResponse updateCompetencies(@Min(1) @NotNull Long id, @Valid CreateCompetenciesRequest competenciesRequest) {
            competenciesRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException(COMPETENCIES_NOT_FOUND_WITH_ID + id));

            return getCompetenciesResponse(competenciesRequest);
        }

        @Override
        @Transactional
        public void deleteCompetencies(@Min(1) @NotNull Long id) {
            competenciesRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException(COMPETENCIES_NOT_FOUND_WITH_ID + id));
            competenciesRepository.deleteById(id);
        }
    }
