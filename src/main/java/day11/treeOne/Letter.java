package day11.treeOne;

public class Letter {
    public static void main(String[] args) {
        TSBNode<String> tier = new TSBNode<>("");
        tier.setSons(new String[]{"A"});
        tier.sons[0].setSons(new String[]{"B", "C", "D"});
        tier.sons[0].sons[0].setSons(new String[]{"E","F"});
        tier.sons[0].sons[0].sons[1].setSons(new String[]{"L","M"});
        tier.sons[0].sons[0].sons[1].sons[1].setSons(new String[]{"P","Q","R"});
        tier.sons[0].sons[0].sons[1].sons[1].sons[1].setSons(new String[]{"S"});
        tier.sons[0].sons[0].sons[1].sons[1].sons[2].setSons(new String[]{"T","U"});
        tier.sons[0].sons[1].setSons(new String[]{"G","H"});
        tier.sons[0].sons[2].setSons(new String[]{"I","J","K"});
        tier.sons[0].sons[2].sons[1].setSons(new String[]{"N","O"});
        show(tier.sons);
    }

    public static void show(TSBNode[] tsbNode){
        for (int length = 0; length < tsbNode.length; length++) {
            System.out.print(tsbNode[length].data+"\t");
            if(tsbNode[length].sons!=null){
                show(tsbNode[length].sons);
            }
        }
    }
}
