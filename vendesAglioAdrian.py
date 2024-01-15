nombres=[]
precios=[]
qVentas=[]
mVentas=0

print("1.Introducir un articulo nuevo\n2.Hacer una venta\n3.Mostrar informacion\n4.Borra  un articulo\n5.Borrar todos los articulos\n6.Salir ")
opcion=int(input("Dime que opcion quieres: "))
if opcion<1 or opcion>6:
    print("Error")
    opcion=int(input("Dime que opcion quieres: "))

repetir=True
while repetir==True:
    ##Introducir nuevo articulo
    if opcion==1:
        nombres.append(input("Dime el nombre del articulo: "))
        precios.append(float(input("Dime el precio del articulo: ")))
    ##Hacer una venta
    if opcion==2:
        articulo=input("Dime el nombre del articulo: ")
        for i in range (len(nombres)):
            if articulo in nombres:
                qVentas.append(int(input("Dime la cantidad vendida: ")))
                break
            else:
                print("Error, no existe ese articulo")
    ##Mostrar información
    if opcion==3:
        invertido=input("¿Quieres mostrar la informacion en orden inverso (s/n)?")
        if invertido=="s" or invertido=="S":
            print(f"{"NOM":<10}  {"QUANT":<7}  {"PREU":^10}  {"IMPORT":>5}")
            total=0
            for i in range(len(nombres)-1, -1, -1):
                importe=precios[i]*qVentas[i]
                print(f"{nombres[i]:<10} {qVentas[i]:<11} {precios[i]:^12} {importe:>7}")
                total+=importe
        else:
            print(f"{"NOM":<10}  {"QUANT":<7}  {"PREU":^10}  {"IMPORT":>5}")
            total=0
            for i in range(len(nombres)):
                importe=precios[i]*qVentas[i]
                print(f"{nombres[i]:<10} {qVentas[i]:<11} {precios[i]:^12} {importe:>7}")
                total+=importe

        print(f"{"TOTAL:":>35} {total}")
        if qVentas:
            mVentas=qVentas.index(max(qVentas))
            print(f"Articulo mas vendido: {nombres[mVentas]}, con {qVentas[mVentas]} unidades")
    ##Borrar un articulo
    if opcion==4:
        articulo=input("Dime el nombre del articulo que quieres borrar: ")
        if articulo in nombres:
            barticulo=nombres.index(articulo)
            nombres.remove(articulo)
            qVentas.pop(barticulo)
            precios.pop(barticulo)
            print("Articulo borrado")
        else:
            print("Articulo no encontrado")
    ##Borrar todos los articulos
    if opcion==5:
        nombres=[]
        precios=[]
        qVentas=[]

    print("1.Introducir un articulo nuevo\n2.Hacer una venta\n3.Mostrar informacion\n4.Borra  un articulo\n5.Borrar todos los articulos\n6.Salir ") 
    opcion=int(input("Dime que opcion quieres: "))
    ##Salir
    if opcion==6:
        salir=input("¿Seguro que quieres salir (s/S)?")
        if salir=="s" or salir=="S":
            repetir=False
        else:
            print("1.Introducir un articulo nuevo\n2.Hacer una venta\n3.Mostrar informacion\n4.Borrar un articulo\n5.Borrar todos los articulos\n6.Salir ")
            opcion=int(input("Dime qué opción quieres: "))
    
    