package org.wzq.bioplat;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CcgepsocreApplicationTests {
//    @Autowired
//    RedisTemplate redisTemplate;
//    @Autowired
//    PertByIDDAO pertByIDDAO;
//    @Autowired
//    ElasticsearchRestTemplate elasticsearchRestTemplate;
//    @Test
//    void contextLoads() throws IOException {
//        String str="bat vatbatta/\\";
//        System.out.println(str.replace("at","<>"));
//    }
//    @Test
//    void createDifGeneAls() throws IOException {
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        ValueOperations<String, DifGeneAls> vo= redisTemplate.opsForValue();
//
//        CsvReader csvReader = new CsvReader("E:\\服务器备份\\TCGA-GTEx\\ES_exp_dif_analysis.csv", ',', Charset.forName("UTF-8"));
//        System.out.println(csvReader.readHeaders());
//        while (csvReader.readRecord()) {
//            if(csvReader.get(1).equals("NA")||csvReader.get(2).equals("NA")||csvReader.get(3).equals("NA")||csvReader.get(4).equals("NA")||csvReader.get(5).equals("NA")||csvReader.get(6).equals("NA"))
//                continue;
//            vo.set("Gene:ES:"+csvReader.get(0),new DifGeneAls(Long.parseLong(csvReader.get(0)),Double.parseDouble(csvReader.get(1)),Double.parseDouble(csvReader.get(4)),Double.parseDouble(csvReader.get(5)),-1));
//        }
//    }
//    @Test
//    void createElasticsearchIndex() throws IOException {
//        CsvReader csvReader = new CsvReader("E:\\服务器备份\\metadata\\aliastab_ver6.csv", ',', Charset.forName("UTF-8"));
//        System.out.println(csvReader.readHeaders());
//        int k=0;
//        while (csvReader.readRecord()) {
//            ++k;
//            System.out.println(k);
//            pertByIDDAO.save(new PertByID(k, Integer.parseInt(csvReader.get(0)),csvReader.get(2)));
//        }
////        System.out.println((Pert)vo.get("2\\',3\\'-dideoxyadenosine"));
//    }
//    @Test
//    void createPertRedis() throws IOException {
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        CsvReader csvReader = new CsvReader("E:\\服务器备份\\metadata\\pert_unique_ver5.csv", ',', Charset.forName("UTF-8"));
//        System.out.println(csvReader.readHeaders());
//        ValueOperations<String, Pert> vo= redisTemplate.opsForValue();
//        int k=0;
//        while (csvReader.readRecord()) {
//            ++k;
//            System.out.println(k);
//            vo.set("Pert:"+csvReader.get(0),new Pert(Integer.parseInt(csvReader.get(0)),csvReader.get(1),csvReader.get(2),csvReader.get(3),csvReader.get(4),csvReader.get(5),csvReader.get(6),""));
//        }
//    }
//
//    @Test
//    void createIndex(){
//
//    }
//    @Test
//    void deleteIndex(){
//        elasticsearchRestTemplate.deleteIndex(PertByID.class);
//    }
//    @Test
//    void seachIndex() throws IOException{
//
////        pertByIDDAO.save(new PertByID(972,"(+-)-1-(2,4-dichlor-beta-((4-chlorbenzyl)thio)phenethyl)imidazol"));
////        pertByIDDAO.save(new PertByID(572,"(+-)-1-(2,4-dichlor-beta-((4-ch42353io)phenethyl)imidazol"));
////        pertByIDDAO.save(new PertByID(372,"(+-)-1-(2,4-dichlor-beta-((4-chlorben264324phenethyl)imidazol"));
////        pertByIDDAO.save(new PertByID(172,"(+-)-1-(2,4-dichlor-beta-((4-ch756645435imidazol"));
//
////        System.out.println(pertByIDDAO.findById(972));
//        QueryBuilder termQueryBuilder1= QueryBuilders.multiMatchQuery("BRD","alias.keyword","alias.lowercase","alias.ngram");
////        QueryBuilder termQueryBuilder1= QueryBuilders.multiMatchQuery=("alias.keyword", "(+-)-1-(2,4-dichlor-beta-((4-chloRBenzyl)thiO)PHENethyl)imidazol");
////        MatchQueryBuilder termQueryBuilder2= QueryBuilders.matchQuery("alias.lowercase", "ChLorbenzyl");
////        MatchQueryBuilder termQueryBuilder3= QueryBuilders.matchQuery("alias.ngram", "2,4-dichl");
//        Iterable<PertByID> pids1=pertByIDDAO.search(termQueryBuilder1);
//        for(PertByID pid:pids1){
//            System.out.println(pid);
//        }
////        Iterable<PertByID> pids2=pertByIDDAO.search(termQueryBuilder2);
////        for(PertByID pid:pids2){
////            System.out.println(pid);
////        }
////        Iterable<PertByID> pids3=pertByIDDAO.search(termQueryBuilder3);
////        for(PertByID pid:pids3){
////            System.out.println(pid);
////        }
//    }
//

}
