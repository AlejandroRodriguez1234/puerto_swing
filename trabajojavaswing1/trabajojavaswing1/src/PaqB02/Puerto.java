package PaqB02;

public class Puerto {
    private static int FILAS = 10;
    private static int COLUMNAS = 12;

    //matriz de contenedores
    private Contenedor[][] hubs;


    //constructor de hubs

    public Puerto(){
        hubs=new Contenedor[FILAS][COLUMNAS];
    }

    //desapilar contenedor

    public void desapilarContenedor(int columna) {
        //this.mostrarPuerto(columna);
        hubs[FILAS-1][columna] = null;
    }

    public void apilarContenedor(Contenedor contenedor) {

        if (contenedor != null){
            int p = contenedor.getPrioridad();
            boolean aux = false;

            if (p == 1) {
                for (int i = FILAS-1; i > 0; i--) {
                    if (hubs[i][1] == null) {
                        hubs[i][1] = contenedor;
                        break;
                    }
                }
            } else if (p == 2) {
                for (int i = FILAS-1; i > 0; i--) {
                    if (hubs[i][2] == null) {
                        hubs[i][2] = contenedor;
                        break;
                    }
                }
            } else {
                for (int j = 3; j < COLUMNAS; j++) {
                    for (int i = FILAS-1; i > 0; i--) {
                        if (hubs[i][j] == null) {
                            hubs[i][j] = contenedor;
                            aux = true;
                            break;
                        }
                    }
                    if (aux) break;
                }
            }
        }
    }

    public String mostrarDatos(int id) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if(hubs[i][j] != null){
                    if (hubs[i][j].getIdContenedor() == id) {
                        return "Id:" + hubs[i][j].getIdContenedor() + " Pais:" + hubs[i][j].getPais_procedencia() + " Peso:" + hubs[i][j].getPesoContenedor() + " Inspeccionado:" + hubs[i][j].isInspeccionado() + " Prioridad:" + hubs[i][j].getPrioridad() + " Descripcion:" + hubs[i][j].getDescripcion_contenido() + " E.enviadora:" + hubs[i][j].getEmpresa_enviadora() + " E.recibidora:" + hubs[i][j].getEmpresa_recibidora();
                    }
                }
            }
        }
        return "El contenedor no está en el HUB";
    }

    public void mostrarPuerto(int columna){
        for (int i = 0; i < FILAS; i++) {
            if(this.hubs[i][columna] == null){
                System.out.println("Fila " + i + " es nula");
            }
            else{
                System.out.println("Fila" + i + " es ");
                this.mostrarDatos(this.hubs[i][columna].getIdContenedor());
            }
        }
    }

    public String toString() {
        String s=" ";
        return s;
    }

    public int cuentaContenedores(String pais) {
        int contador = 0;

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if(hubs[i][j]!=null){
                    if(hubs[i][j].getPais_procedencia()==pais){
                        contador++;
                    }
                }

            }
        }
        return contador;
    }


//aqui añado el metodo pesoTotalHub()
    public float pesoTotalHub() {
        float pesoTotal = 0;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (hubs[i][j] != null) {
                    pesoTotal += hubs[i][j].getPeso();
                }
            }
        }
        return pesoTotal;
    }
}
