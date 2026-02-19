SELECT count(*) as COUNT
from ECOLI_DATA
WHERE genotype & 2 = 0
AND (
(genotype & 1) > 0 OR (genotype & 4 > 0)
)