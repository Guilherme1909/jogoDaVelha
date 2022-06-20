programa
{
	inclua biblioteca Util --> u
	inclua biblioteca Mouse --> m
	inclua biblioteca Graficos --> g
    
	funcao inicio()
	{	
		inteiro pos0 = -1
		inteiro jogador = -1
		inteiro jogo
		inteiro dnv
		cadeia velha[3][3] = {{" "," "," "}, {" "," "," "}, {" "," "," "}}
		cadeia sinal
		g.iniciar_modo_grafico(verdadeiro)
		jogo = menu()
		desenha(velha)
		faca{
			jogador = jogador * -1
			faca{
				se(jogo == 1){
					se(jogador == 1 ou jogador == -1){
						enquanto(nao m.algum_botao_pressionado()){
						}
						pos0 = ondeEuCliquei(m.posicao_x(), m.posicao_y())
					}
				}
				se(jogo == 2){
					se(jogador == 1){
						enquanto(nao m.algum_botao_pressionado()){
						}
						pos0 = ondeEuCliquei(m.posicao_x(), m.posicao_y())
					}
					senao{
						u.aguarde(500)
						pos0 = bot(jogador)
					}
				}
			}enquanto(nao verifica(pos0, velha))
				
			coloca(pos0, jogador, velha)
			desenha(velha)
			}enquanto(vencedor(velha) == 0)
			
		se(vencedor(velha) == 2){
			desenha_velha()
		}
		se(jogo == 1){
			se(vencedor(velha) == 1 e jogador == 1){
				escreva("jogador X venceu!")
				desenha_venceu()
			}
			se(vencedor(velha) == 1 e jogador == -1){
				escreva("jogador O venceu!")
				desenha_venceu()
			}
		}
		se(jogo == 2){
			se(vencedor(velha) == 1 e jogador == 1){
				escreva("jogador X venceu!")
				desenha_venceu()
			}
			se(vencedor(velha) == 1 e jogador == -1){
				escreva("jogador O venceu!")
				desenha_perdeu()
			}
		}
	}
//desenha o jogo
	funcao desenha(cadeia jogo[][]){
		g.definir_cor(g.COR_BRANCO)
		g.desenhar_linha(200, 20, 200, 435)
		g.desenhar_linha(400, 20, 400, 435)
		g.desenhar_linha(10, 150, 600, 150)
		g.desenhar_linha(10, 300, 600, 300)
		
     	g.definir_cor(g.COR_VERMELHO)
		g.definir_tamanho_texto(48.0)
		g.definir_estilo_texto(falso, verdadeiro, falso)
     	para(inteiro p = 0; p < 9; p++){
     		//linha 1
			se(p == 0){
				g.desenhar_texto(85, 60, jogo[0][0])
	          }
	          se(p == 1){
				g.desenhar_texto(285, 60, jogo[0][1])	
	          }
	          se(p == 2){
				g.desenhar_texto(485, 60, jogo[0][2])
	          }
	          //linha 2
	          se(p == 3){
				g.desenhar_texto(85, 205, jogo[1][0])
	          }
	          se(p == 4){
				g.desenhar_texto(285, 205, jogo[1][1])	
	          }
	          se(p == 5){
				g.desenhar_texto(485, 205, jogo[1][2])
	          }
	          //linha 3
	          se(p == 6){
				g.desenhar_texto(85, 350, jogo[2][0])
	          }
	          se(p == 7){
				g.desenhar_texto(285, 350, jogo[2][1])	
	          }
	          se(p == 8){
				g.desenhar_texto(485, 350, jogo[2][2])
          	}
     	}
     	g.definir_cor(g.COR_AMARELO)
          se(jogo[0][0] == jogo[0][1] e jogo[0][0] == jogo[0][2] e jogo[0][0] != " "){
			g.desenhar_linha(50, 80, 550, 80)
		}
		se(jogo[1][0] == jogo[1][1] e jogo[1][0] == jogo[1][2] e jogo[1][0] != " "){
			g.desenhar_linha(50, 225, 550, 225)
		}
		se(jogo[2][0] == jogo[2][1] e jogo[2][0] == jogo[2][2] e jogo[2][0] != " "){
			g.desenhar_linha(50, 370, 550, 370)
		}
		//coluna
		se(jogo[0][0] == jogo[1][0] e jogo[0][0] == jogo[2][0] e jogo[0][0] != " "){
			g.desenhar_linha(100, 30, 100, 405)
		}
		se(jogo[0][1] == jogo[1][1] e jogo[0][1] == jogo[2][1] e jogo[0][1] != " "){
			g.desenhar_linha(300, 30, 300, 405)
		}
		se(jogo[0][2] == jogo[1][2] e jogo[0][2] == jogo[2][2] e jogo[0][2] != " "){
			g.desenhar_linha(500, 30, 500, 405)
		}
		//diagonal
		se(jogo[0][0] == jogo[1][1] e jogo[0][0] == jogo[2][2] e jogo[0][0] != " "){
			g.desenhar_linha(50, 40, 540, 405)
		}
		se(jogo[0][2] == jogo[1][1] e jogo[0][2] == jogo[2][0] e jogo[0][2] != " "){
			g.desenhar_linha(550, 40, 55, 405)
		}
     	g.renderizar()
	}
//mostra as cordenadas e devolve uma posição
	funcao inteiro ondeEuCliquei(inteiro x, inteiro y){
		inteiro pos = -1
		//linha 1
		se(x > 10 e x < 200 e y > 20 e y < 145){
			se(m.ler_botao() == 0){
				pos = 0
			}
		}
		se(x > 200 e x < 400 e y > 20 e y < 145){
			se(m.ler_botao() == 0){
				pos = 1
			}
		}
		se(x > 400 e x < 580 e y > 20 e y < 145){
			se(m.ler_botao() == 0){
				pos = 2
			}
		}
		//linha 2
		se(x > 10 e x < 200 e y > 155 e y < 295){
			se(m.ler_botao() == 0){
				pos = 3
			}
		}
		se(x > 200 e x < 400 e y > 155 e y < 295){
			se(m.ler_botao() == 0){
				pos = 4
			}
		}
		se(x > 400 e x < 580 e y > 155 e y < 295){
			se(m.ler_botao() == 0){
				pos = 5
			}
		}
		//linha 3
		se(x > 10 e x < 200 e y > 300 e y < 420){
			se(m.ler_botao() == 0){
				pos = 6
			}
		}
		se(x > 200 e x < 400 e y > 300 e y < 420){
			se(m.ler_botao() == 0){
				pos = 7
			}
		}
		se(x > 400 e x < 580 e y > 300 e y < 420){
			se(m.ler_botao() == 0){
				pos = 8
			}
		}
		retorne pos
	}
//coloca X ou Y
	funcao coloca(inteiro pos, inteiro jog, cadeia jogo[][]){
		//linha 1
		cadeia sin
		se(jog == 1){
				sin = "X"
			}
			senao{
				sin = "O"
			}
		se(pos == 0){
			jogo[0][0] = sin
          }
          se(pos == 1){
			jogo[0][1] = sin
          }
          se(pos == 2){
           	jogo[0][2] = sin
          }
          //linha 2
          se(pos == 3){
			jogo[1][0] = sin
          }
          se(pos == 4){
			jogo[1][1] = sin
          }
          se(pos == 5){
           	jogo[1][2] = sin
          }
          //linha 3
          se(pos == 6){
			jogo[2][0] = sin
          }
          se(pos == 7){
			jogo[2][1] = sin
          }
          se(pos == 8){
           	jogo[2][2] = sin
          }
	}
//verifica se a posição já está sendo usada
	funcao logico verifica(inteiro pos, cadeia jogo[][]){
		se(pos == 0){
			se(jogo[0][0] == " "){
				retorne verdadeiro
			}
		}
		se(pos == 1){
			se(jogo[0][1] == " "){
				retorne verdadeiro
			}
		}
		se(pos == 2){
			se(jogo[0][2] == " "){
				retorne verdadeiro
			}
		}
		se(pos == 3){
			se(jogo[1][0] == " "){
				retorne verdadeiro
			}
		}
		se(pos == 4){
			se(jogo[1][1] == " "){
				retorne verdadeiro
			}
		}
		se(pos == 5){
			se(jogo[1][2] == " "){
				retorne verdadeiro
			}
		}
		se(pos == 6){
			se(jogo[2][0] == " "){
				retorne verdadeiro
			}
		}
		se(pos == 7){
			se(jogo[2][1] == " "){
				retorne verdadeiro
			}
		}
		se(pos == 8){
			se(jogo[2][2] == " "){
				retorne verdadeiro
			}
		}
		retorne falso
	}
//vencedor
	funcao inteiro vencedor(cadeia jogo[][]){
		inteiro ganhador = 0
		//linha
		se(jogo[0][0] == jogo[0][1] e jogo[0][0] == jogo[0][2] e jogo[0][0] != " "){
			ganhador = 1
		}
		se(jogo[1][0] == jogo[1][1] e jogo[1][0] == jogo[1][2] e jogo[1][0] != " "){
			ganhador = 1
		}
		se(jogo[2][0] == jogo[2][1] e jogo[2][0] == jogo[2][2] e jogo[2][0] != " "){
			ganhador = 1
		}
		//coluna
		se(jogo[0][0] == jogo[1][0] e jogo[0][0] == jogo[2][0] e jogo[0][0] != " "){
			ganhador = 1
		}
		se(jogo[0][1] == jogo[1][1] e jogo[0][1] == jogo[2][1] e jogo[0][1] != " "){
			ganhador = 1
		}
		se(jogo[0][2] == jogo[1][2] e jogo[0][2] == jogo[2][2] e jogo[0][2] != " "){
			ganhador = 1
		}
		//diagonal
		se(jogo[0][0] == jogo[1][1] e jogo[0][0] == jogo[2][2] e jogo[0][0] != " "){
			ganhador = 1
		}
		se(jogo[0][2] == jogo[1][1] e jogo[0][2] == jogo[2][0] e jogo[0][2] != " "){
			ganhador = 1
		}
		inteiro cheio = 0
		para(inteiro l = 0; l < 3; l++){
     		para (inteiro c = 0;c < 3; c++){
     			se(jogo[l][c] == "O" ou jogo[l][c] == "X"){
     				cheio = cheio + 1
     			}
     		}
     	}
     	se(cheio == 9 e ganhador != 1){
     		ganhador = 2
     	}
		retorne ganhador
	}
//velha
	funcao desenha_velha(){
		inteiro imagem = g.carregar_imagem("velha.png")
     	escreva("Velha!!")
     	g.definir_cor(g.COR_VERMELHO)
     	g.desenhar_imagem(0, 0, imagem)
     	g.definir_estilo_texto(falso, verdadeiro, verdadeiro)
		g.desenhar_texto(30, 30, "Velha")
		u.aguarde(500)
		g.renderizar()
		u.aguarde(2000)
	}
//vcvenceu
	funcao desenha_venceu(){
		inteiro imagem = g.carregar_imagem("vcvenceu.png")
     	g.definir_cor(g.COR_AMARELO)
     	g.desenhar_imagem(150, 150, imagem)
     	g.definir_estilo_texto(falso, verdadeiro, verdadeiro)
		g.desenhar_texto(200, 30, "Parabéns!")
		u.aguarde(500)
		g.renderizar()
		u.aguarde(2000)
	}
//vcperdeu
	funcao desenha_perdeu(){
		inteiro imagem = g.carregar_imagem("vcperdeu.png")
     	g.definir_cor(g.COR_AZUL)
     	g.desenhar_imagem(210, 200, imagem)
     	g.definir_estilo_texto(falso, verdadeiro, verdadeiro)
		g.desenhar_texto(70, 30, "HAHAHA! EU VENCI!!")
		u.aguarde(500)
		g.renderizar()
		u.aguarde(2000)
	}
//bot
	funcao inteiro bot(inteiro jog){
		inteiro pos
		pos = u.sorteia(0, 8)
		retorne pos
	}
//menu
	funcao inteiro menu(){
		inteiro imagem = g.carregar_imagem("modojogo.png")
     	g.desenhar_imagem(105, 250, imagem)
     	g.definir_cor(g.COR_AMARELO)
     	g.definir_estilo_texto(falso, verdadeiro, falso)
     	g.definir_tamanho_texto(70.0)
		g.desenhar_texto(35, 50, "JOGO DA VELHA")
		g.renderizar()
		inteiro pos = -1
		faca{
			enquanto(nao m.algum_botao_pressionado()){
			}
			pos = ondeEuCliqueiMenu(m.posicao_x(), m.posicao_y())
		}enquanto(pos != 1 e pos != 2)
		inteiro jogo = -1
		se(pos == 1){
			jogo = 1
		}
		se(pos == 2){
			jogo = 2
		}
		retorne jogo
	}
//ondeEuCliqueiMenu
	funcao inteiro ondeEuCliqueiMenu(inteiro x, inteiro y){
		inteiro pos = -1
		se(x > 105 e x < 290 e y > 250 e y < 320){
			se(m.ler_botao() == 0){
				pos = 1
			}
		}
		se(x > 338 e x < 539 e y > 250 e y < 320){
			se(m.ler_botao() == 0){
				pos = 2
			}
		}
		retorne pos
	}
}
