package ca.uqac.ecommerce.party;

public class Spaceship extends Party {

    private Integer totalCapacity;
    private Integer currentLoad;
    private Route route;

    public class Route{
        private Planet origin;
        private Planet destination;

        public Planet getOrigin() {
            return origin;
        }

        public void setOrigin(Planet origin) {
            this.origin = origin;
        }

        public Planet getDestination() {
            return destination;
        }

        public void setDestination(Planet destination) {
            this.destination = destination;
        }
    }

    public Spaceship(Container[] containers) {
        super(containers);
    }

    private Integer calculateTotalCapacity(){
        // @TODO
        return totalCapacity;
    }

    private Integer calculateCurrentLoadCapacity(){
        // @TODO
        return currentLoad;
    }

    public Integer getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Integer totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public Integer getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(Integer currentLoad) {
        this.currentLoad = currentLoad;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
