import matplotlib.pyplot as plt
import numpy as np

angles = [np.pi/2 - i * (4 * np.pi / 5) for i in range(6)]
x = np.cos(angles)
y = np.sin(angles)

colors = ['#E06045', '#FFF856', '#417D28', '#A5B7F8', '#DB8375']

plt.figure(figsize=(6, 6))

for i in range(5):
    plt.plot(x[i:i+2], y[i:i+2], color=colors[i], linewidth=5)

plt.title("Five-Line Star with Custom Colors", fontsize=14)
plt.xlim(-1.1, 1.1)
plt.ylim(-1.1, 1.1)
plt.axis('off')

plt.show()