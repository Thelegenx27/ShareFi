package com.example.sharefi;

public class SongCollection {
    private Song[] songs = new Song[7];
    public SongCollection() {
        Song TheBox = new Song("The_Box", "The Box", "Roddy Ricch", "https://p.scdn.co/mp3-preview/efbcc9db8f3ad5b8fc9b379bbf93f991e47c7358?cid=2afe87a64b0042dabf51f37318616965", 3.28, R.drawable.box);
        Song Ronaldo = new Song("Ronaldo", "Ronaldo (SEWY)", "IShowSpeed", "https://p.scdn.co/mp3-preview/6ac37c4db188fbbbe83b85d3184ab5db546d16d5?cid=2afe87a64b0042dabf51f37318616965", 1.7, R.drawable.sewy);
        Song GodIsGood = new Song("godIsGood", "God Is Good", "IShowSpeed", "https://p.scdn.co/mp3-preview/60de9234d0086064ac0ef8fb1fcdd0493c824bf8?cid=2afe87a64b0042dabf51f37318616965", 2.63, R.drawable.speed);
        Song WhatsPoppin = new Song("WhatsPoppin","What's Poppin", "Jack Harlow", "https://p.scdn.co/mp3-preview/7100aaf1332530595343a7a32a72d7dccbcc77cf?cid=2afe87a64b0042dabf51f37318616965", 2.33, R.drawable.poppin);
        Song IndustryBaby = new Song("IndustryBaby", "Industry Baby", "Lil Nas X & Jack Harlow", "https://p.scdn.co/mp3-preview/c1ab4a1b3403a8f6ac578ab5081f295751e9f1ca?cid=2afe87a64b0042dabf51f37318616965", 3.53, R.drawable.industry);
        Song WhatsPopping = new Song("whatspoppinvariousartist", "Whats Poppin'","Jack Harlow, Tory Lanez, Dababy, Lil Wayne", "https://p.scdn.co/mp3-preview/bbaffb953cebd62fdb759575ddac821085f92415?cid=2afe87a64b0042dabf51f37318616965", 3.79, R.drawable.poppinremix);

        songs[0] = TheBox;
        songs[1] = Ronaldo;
        songs[2] = GodIsGood;
        songs[3] = WhatsPoppin;
        songs[4] = IndustryBaby;
        songs[5] = WhatsPopping;
    }


    public Song getCurrentSong(int currentSongId){

        return songs[currentSongId];
    }

    public int searchSongById(String id){
        for(int index=0; index < songs.length; index++){
            Song tempSong = songs[index];
            if(tempSong.getId().equals(id)){
                return index;
            }
        }
        return -1;
    }

    public int getNextSong(int currentSongIndex){
        if (currentSongIndex >= songs.length-1){
            return currentSongIndex;
        }
        else{
            return currentSongIndex +1;
        }
    }

    public int getPrevSong(int currentSongIndex){
        if (currentSongIndex <= 0){
            return currentSongIndex;
        }
        else{
            return currentSongIndex -1;
        }
    }
}
