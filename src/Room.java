import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Room {
    public static final int capacity=10;
    private static int i=0;
    private int currentSelfInRoom;
    private int roomNo;
    private List<Shelf> shelves;
    private Set<String> genres;

    public Room() {
        roomNo=IdGenrator();
        shelves=new ArrayList<>();
        genres=new HashSet<>();
        currentSelfInRoom=0;
    }

    public int getCurrentSelfInRoom() {
        return currentSelfInRoom;
    }

    public void setCurrentSelfInRoom(int currentSelfInRoom) {
        this.currentSelfInRoom = currentSelfInRoom;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public void addShelfToRoom(Shelf shelf){
        shelves.add(shelf);
    }
    public void addGenresToRoom(String gen){
        genres.add(gen);
    }
    public boolean canRoomHavingThisGenresBook(String test){
        return genres.contains(test);
    }
    public List<Shelf> shelvesHavingThisGenres(String bookGenres) {
        List<Shelf>shelfList=new ArrayList<>();
        for (Shelf shelf:shelves){
            if(shelf.getGenres().equalsIgnoreCase(bookGenres)){
                shelfList.add(shelf);
            }
        }
        return shelfList;
    }

    public boolean findSelfWithGenresHavingBookID(String genres, int bookId) {
        for (Shelf shelf:shelves){
            if (shelf.getGenres().equalsIgnoreCase(genres)){
                if(shelf.findBookedWithBookId(bookId)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean findRoomHavingSapce(Book book){
        for (Shelf shelf:shelves){
            if (shelf.getGenres().equalsIgnoreCase(book.getGenres())){
                if(shelf.findSelfHavingSpace(book)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean addNewBookInRoom(Book book){
        for (Shelf shelf:shelves){
            if(shelf.getGenres().equalsIgnoreCase(book.getGenres()) && shelf.addNewBook(book)){
                return true;
            }
        }
        if(currentSelfInRoom< capacity){
            Shelf shelf=new Shelf(book.getGenres());
            shelves.add(shelf);
            shelf.addNewBook(book);
            genres.add(book.getGenres());
            currentSelfInRoom++;
            return true;
        }

        return false;
    }

    public boolean removeBookInRoom(Book book) {
        for (Shelf shelf:shelves){
            if(shelf.getGenres().equalsIgnoreCase(book.getGenres())){
                if(shelf.removeBookInSelf(book)){
                    return true;
                }
            }
        }
        return false;
    }
    private synchronized int IdGenrator() {
        i++;
        return i;
    }
}
